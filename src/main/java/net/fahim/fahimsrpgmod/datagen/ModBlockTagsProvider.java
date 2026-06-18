package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, FahimsRPGMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.RAW_AZURITE_BLOCK.get())
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK.get())
                .add(ModBlocks.PINK_GARNET_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.PINK_GARNET_ORE.get())
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.PINK_GARNET_STAIRS.get())
                .add(ModBlocks.PINK_GARNET_SLAB.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.PINK_GARNET_ORE.get())
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get())
                .add(ModBlocks.PINK_GARNET_END_ORE.get())
                .add(ModBlocks.PINK_GARNET_NETHER_ORE.get());

        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES);

        tag(ModTags.Blocks.NEEDS_AZURITE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_AZURITE_TOOL)
                .addTags(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_AZURITE_TOOL);

        tag(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.NEEDS_AZURITE_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL)
                .addTags(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL);

    }
}
