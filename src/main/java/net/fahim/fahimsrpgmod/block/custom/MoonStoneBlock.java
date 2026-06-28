package net.fahim.fahimsrpgmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class MoonStoneBlock extends Block {

    public MoonStoneBlock(Properties properties) {
        super(properties);
    }

    private static boolean isNight(ServerLevel level) {
        long time = level.getDayTime() % 24000L;
        return time >= 13000L && time <= 23000L;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) level;
            if (isNight(serverLevel)) {
                if (entity instanceof LivingEntity living) {
                    applyMoonEffects(living);
                }
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isNight(level)) {
            AABB area = new AABB(pos).inflate(5.0);
            List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, area);
            for (LivingEntity living : nearbyEntities) {
                applyMoonEffects(living);
            }
        }
    }

    private void applyMoonEffects(LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true));
        entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 0, false, true));
        entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 260, 0, false, true));
    }
}