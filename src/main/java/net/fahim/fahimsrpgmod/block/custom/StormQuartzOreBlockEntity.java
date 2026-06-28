package net.fahim.fahimsrpgmod.block.custom;

import net.fahim.fahimsrpgmod.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class StormQuartzOreBlockEntity extends BlockEntity {

    private int charge = 100;
    private boolean discharging = false;
    private int dischargeCooldown = 0;

    private static final int DISCHARGE_DURATION = 200;
    private static final int AURA_TICK_INTERVAL = 20;
    private static final double AURA_RANGE = 3.0;
    private static final double CHAIN_RANGE = 8.0;

    public StormQuartzOreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STORM_QUARTZ_ORE_BE.get(), pos, state);
    }

    // ── Tick entry point ─────────────────────────────────────────────────────

    public static void tick(Level level, BlockPos pos, BlockState state,
                            StormQuartzOreBlockEntity be) {
        if (level.isClientSide()) {
            be.clientTick(level, pos);
        } else {
            be.serverTick((ServerLevel) level, pos);
        }
    }

    // ── Client tick ──────────────────────────────────────────────────────────

    private void clientTick(Level level, BlockPos pos) {
        if (charge <= 0) return;

        float intensity = charge / 100f;

        if (level.getRandom().nextFloat() < intensity * 0.4f) {
            double ox = (level.getRandom().nextDouble() - 0.5) * 0.8;
            double oz = (level.getRandom().nextDouble() - 0.5) * 0.8;
            level.addParticle(ParticleTypes.ELECTRIC_SPARK,
                    pos.getX() + 0.5 + ox,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5 + oz,
                    0, 0.05 * intensity, 0);
        }

        if (charge > 50 && level.getRandom().nextFloat() < 0.15f) {
            level.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    0, 0.02, 0);
        }

        if (level.getGameTime() % 20 == 0) {
            float volume = 0.1f + (intensity * 0.6f);
            float pitch  = 0.8f + (intensity * 0.4f);
            level.playLocalSound(
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.BEACON_AMBIENT,
                    SoundSource.BLOCKS,
                    volume, pitch, false);
        }
    }

    // ── Server tick ──────────────────────────────────────────────────────────

    private void serverTick(ServerLevel level, BlockPos pos) {
        if (discharging) {
            dischargeCooldown--;
            charge = Math.max(0, 100 - (dischargeCooldown * 100 / DISCHARGE_DURATION));
            if (dischargeCooldown <= 0) {
                discharging = false;
                charge = 100;
            }
            setChanged();
            return;
        }

        if (level.getGameTime() % AURA_TICK_INTERVAL != 0) return;

        boolean isThunder = level.isThundering();
        float auraDamage = isThunder ? 2.0f : 1.0f;
        double cx = pos.getX() + 0.5, cy = pos.getY() + 0.5, cz = pos.getZ() + 0.5;

        for (Player player : level.players()) {
            if (player.isCreative() || player.isSpectator()) continue;
            if (player.distanceToSqr(cx, cy, cz) > AURA_RANGE * AURA_RANGE) continue;

            player.hurtServer(level, level.damageSources().magic(), auraDamage);

            level.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                    player.getX(), player.getY() + 1, player.getZ(),
                    isThunder ? 40 : 20, 0.4, 0.6, 0.4, 0.02);
        }
    }

    // ── Step trigger (called from block) ─────────────────────────────────────

    public void onPlayerStep(ServerLevel level, BlockPos pos, Player player) {
        if (charge <= 0 || discharging) return;

        spawnLightning(level, player.getX(), player.getY() + 1, player.getZ());
        player.hurtServer(level, level.damageSources().lightningBolt(), 8.0f);

        boolean isThunder = level.isThundering();
        double chainRange = isThunder ? CHAIN_RANGE * 1.5 : CHAIN_RANGE;

        List<LivingEntity> nearby = level.getEntitiesOfClass(
                LivingEntity.class,
                new AABB(pos).inflate(chainRange),
                e -> e != player && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(e)
        );

        int chainCount = isThunder ? 4 : 2;
        for (int i = 0; i < Math.min(chainCount, nearby.size()); i++) {
            LivingEntity target = nearby.get(i);
            spawnLightning(level, target.getX(), target.getY() + 1, target.getZ());
            target.hurtServer(level, level.damageSources().lightningBolt(), 4.0f);
        }

        discharging = true;
        dischargeCooldown = DISCHARGE_DURATION;
        charge = 100;
        setChanged();
    }

    private void spawnLightning(ServerLevel level, double x, double y, double z) {
        LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        bolt.setPos(x, y, z);
        level.addFreshEntity(bolt);
    }

    // ── NBT ──────────────────────────────────────────────────────────────────

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("charge", charge);
        output.putBoolean("discharging", discharging);
        output.putInt("dischargeCooldown", dischargeCooldown);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        charge = input.getIntOr("charge", 100);
        discharging = input.getBooleanOr("discharging", false);
        dischargeCooldown = input.getIntOr("dischargeCooldown", 0);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public int getCharge() { return charge; }
    public boolean isDischarging() { return discharging; }
}