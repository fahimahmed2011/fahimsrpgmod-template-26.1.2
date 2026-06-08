package net.fahim.fahimsrpgmod.block.custom;

import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;

public class MagicBlock extends Block {

    // A simple record to pair a specific Item with its custom percentage chance
    private static record DropChance(Item item, double percentageChance) {}

    // Register your custom drop pool here. Ensure all chances sum up exactly to 100.0
    private static final List<DropChance> DROP_POOL = new ArrayList<>();

    static {
        // Highly common drops
        DROP_POOL.add(new DropChance(Items.STONE, 40.0));                 // 40% chance
        DROP_POOL.add(new DropChance(Items.DIRT, 30.0));                  // 30% chance
        DROP_POOL.add(new DropChance(Items.RAW_IRON, 20.0));              // 20% chance
        DROP_POOL.add(new DropChance(Items.HAY_BLOCK, 20.0));              // 20% chance
        DROP_POOL.add(new DropChance(Items.BRICKS, 20.0));              // 20% chance

        // Rarer drops
        DROP_POOL.add(new DropChance(Items.GOLD_ORE, 14.9999999999));    // 14.9999999999% chance
        DROP_POOL.add(new DropChance(Items.DIAMOND, 5.0));              // 5% chance

        // Ultra rare Easter Egg drop requested
        DROP_POOL.add(new DropChance(Items.BEDROCK, 0.00000000001));     // 0.00000000001% chance
    }

    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            level.addParticle(ParticleTypes.END_ROD, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);
        }
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 2f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        if (!level.isClientSide()) {
            if (entity instanceof Player player) {
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300));
            }

            if (entity instanceof ItemEntity itemEntity) {
                ItemStack currentStack = itemEntity.getItem();

                if (isValidInputItem(currentStack)) {
                    // Pull Minecraft's built-in secure random number generator
                    RandomSource random = level.getRandom();

                    // Select a random item from our weighted drop table
                    Item chosenItem = getRandomDrop(random);

                    if (chosenItem != null) {
                        ItemStack outputStack = new ItemStack(chosenItem, currentStack.getCount());
                        itemEntity.setItem(outputStack);

                        // Play an audio cue confirming the conversion worked
                        level.playSound(null, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                    }
                }
            }
        }
        super.stepOn(level, pos, onState, entity);
    }

    // Checks if the dropped item is Raw Pink Garnet or Azurite
    private boolean isValidInputItem(ItemStack item) {
        // Adjust these exact registry references to match your ModItems variables
        return item.is(ModItems.RAW_PINK_GARNET) || item.is(ModItems.AZURITE);
    }

    // Loops through the pool and rolls a random double between 0.0 and 100.0
    private Item getRandomDrop(RandomSource random) {
        double roll = random.nextDouble() * 100.0; // Roll from 0.0 to 100.0
        double cumulativeChance = 0.0;

        for (DropChance drop : DROP_POOL) {
            cumulativeChance += drop.percentageChance();
            if (roll <= cumulativeChance) {
                return drop.item();
            }
        }

        // Fallback safety in case percentages don't add up perfectly to 100.0
        return Items.COAL;
    }
}
