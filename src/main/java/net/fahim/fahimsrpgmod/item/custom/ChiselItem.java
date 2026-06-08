package net.fahim.fahimsrpgmod.item.custom;

import net.fahim.fahimsrpgmod.block.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import com.mojang.blaze3d.platform.InputConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            new HashMap<>(Map.ofEntries(
                    // Stone types
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE),
                    Map.entry(Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS),
                    Map.entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    Map.entry(Blocks.SAND, Blocks.SANDSTONE),
                    Map.entry(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    Map.entry(Blocks.RED_SAND, Blocks.RED_SANDSTONE),
                    Map.entry(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    Map.entry(Blocks.GRAVEL, Blocks.COARSE_DIRT),
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                    Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
                    Map.entry(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE),
                    Map.entry(Blocks.BASALT, Blocks.POLISHED_BASALT),
                    Map.entry(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK),
                    Map.entry(Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR),
                    Map.entry(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE),
                    Map.entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES),
                    Map.entry(Blocks.DEEPSLATE_TILES, Blocks.CHISELED_DEEPSLATE),
                    Map.entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
                    Map.entry(Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE),
                    Map.entry(Blocks.SNOW_BLOCK, Blocks.PACKED_ICE),
                    Map.entry(Blocks.PACKED_ICE, Blocks.BLUE_ICE),
                    Map.entry(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN),
                    Map.entry(Blocks.GOLD_BLOCK, Blocks.BEDROCK),

                    // Dirt/Nature
                    Map.entry(Blocks.DIRT, Blocks.DIRT_PATH),
                    Map.entry(Blocks.GRASS_BLOCK, Blocks.DIRT),
                    Map.entry(Blocks.MYCELIUM, Blocks.DIRT),
                    Map.entry(Blocks.PODZOL, Blocks.DIRT),
                    Map.entry(Blocks.ROOTED_DIRT, Blocks.DIRT),

                    // Logs -> Stripped
                    Map.entry(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG),
                    Map.entry(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG),
                    Map.entry(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG),
                    Map.entry(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG),
                    Map.entry(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG),
                    Map.entry(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG),
                    Map.entry(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG),
                    Map.entry(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG),
                    Map.entry(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK),
                    Map.entry(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM),
                    Map.entry(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM),

                    // Wood -> Stripped
                    Map.entry(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD),
                    Map.entry(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD),
                    Map.entry(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD),
                    Map.entry(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD),
                    Map.entry(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD),
                    Map.entry(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD),
                    Map.entry(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD),
                    Map.entry(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD),
                    Map.entry(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE),
                    Map.entry(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE),

                    // Ores -> Blocks
                    Map.entry(Blocks.DIAMOND_ORE, Blocks.DIAMOND_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.REDSTONE_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_BLOCK),
                    Map.entry(Blocks.GOLD_ORE, Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.IRON_ORE, Blocks.IRON_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_BLOCK),
                    Map.entry(Blocks.EMERALD_ORE, Blocks.EMERALD_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_BLOCK),
                    Map.entry(Blocks.LAPIS_ORE, Blocks.LAPIS_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_BLOCK),
                    Map.entry(Blocks.REDSTONE_ORE, Blocks.REDSTONE_BLOCK),
                    Map.entry(Blocks.COAL_ORE, Blocks.COAL_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_COAL_ORE, Blocks.COAL_BLOCK),
                    Map.entry(Blocks.COPPER_ORE, Blocks.COPPER_BLOCK),
                    Map.entry(Blocks.DEEPSLATE_COPPER_ORE, Blocks.COPPER_BLOCK),
                    Map.entry(Blocks.NETHER_GOLD_ORE, Blocks.GOLD_BLOCK),
                    Map.entry(Blocks.NETHER_QUARTZ_ORE, Blocks.QUARTZ_BLOCK),
                    Map.entry(Blocks.ANCIENT_DEBRIS, Blocks.NETHERITE_BLOCK),

                    // Mod ores
                    Map.entry(ModBlocks.PINK_GARNET_ORE.get(), ModBlocks.PINK_GARNET_BLOCK.get()),
                    Map.entry(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get(), ModBlocks.PINK_GARNET_BLOCK.get()),
                    Map.entry(ModBlocks.PINK_GARNET_NETHER_ORE.get(), ModBlocks.PINK_GARNET_BLOCK.get()),
                    Map.entry(ModBlocks.PINK_GARNET_END_ORE.get(), ModBlocks.PINK_GARNET_BLOCK.get())
            ));

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Block clickedBlock = level.getBlockState(pos).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            ServerPlayer player = (ServerPlayer) context.getPlayer();
            if (player == null) return InteractionResult.FAIL;

            level.setBlock(pos, CHISEL_MAP.get(clickedBlock).defaultBlockState(), 3);
            context.getItemInHand().hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

            level.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
        }

        return InteractionResult.SUCCESS;
    }
    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack stack,
                                Item.TooltipContext context,
                                net.minecraft.world.item.component.TooltipDisplay tooltipDisplay,
                                java.util.function.Consumer<Component> tooltipComponents,
                                TooltipFlag tooltipFlag) {

        if (tooltipFlag.hasShiftDown()) {
            tooltipComponents.accept(Component.literal("§bTransforms stones, logs, and ores into advanced variations."));
        } else {
            tooltipComponents.accept(Component.literal("§7Hold §eSHIFT§7 for details"));
        }

        super.appendHoverText(stack, context, tooltipDisplay, tooltipComponents, tooltipFlag);
    }}