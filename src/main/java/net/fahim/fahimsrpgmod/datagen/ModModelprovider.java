package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.block.custom.CauliflowerCropBlock;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.CropBlock;

public class ModModelprovider extends ModelProvider {
    public ModModelprovider(PackOutput output) {
        super(output, FahimsRPGMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Items
        itemModels.generateFlatItem(ModItems.AZURITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AZURITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_PINK_GARNET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PINK_GARNET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHISEL_ITEM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.END_FIRE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STARLIGHT_ASHES.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_HORSE_ARMOUR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PINK_GARNET_HORSE_ARMOUR.get(), ModelTemplates.FLAT_ITEM);
        //Food
        itemModels.generateFlatItem(ModItems.ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CAULIFLOWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CAULIFLOWER_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        blockModels.createCropBlock(
                ModBlocks.CAULIFLOWER_CROP.get(),
                CauliflowerCropBlock.AGE,
                0, 1, 2, 3, 4, 5, 6);

        //MoonStone
        blockModels.createTrivialCube(ModBlocks.MOON_STONE.get());

        //Stone Crystal Ore
        blockModels.createTrivialCube(ModBlocks.STONE_CRYSTAL_ORE.get());

        //Mythril Ore
        blockModels.createTrivialCube(ModBlocks.MYTHRIL_ORE.get());

        //Lightning Item
        itemModels.generateFlatItem(ModItems.RAW_STORM_QUARTZ.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STORM_QUARTZ.get(), ModelTemplates.FLAT_ITEM);



        //Garnet
        itemModels.generateFlatItem(ModItems.GARNETS_WRATH.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GARNET_CLEAVER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GARNET_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GARNET_DELVER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GARNET_TILLER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GARNET_SCYTHE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


        // Azurite tools
        itemModels.generateFlatItem(ModItems.AZURITE_SPEAR.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        // Garnet armour
        itemModels.generateFlatItem(ModItems.PINK_GARNET_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PINK_GARNET_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PINK_GARNET_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PINK_GARNET_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        // Azurite armour
        itemModels.generateFlatItem(ModItems.AZURITE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        // Onyx
        blockModels.createTrivialCube(ModBlocks.ONYX_ORE.get());
        itemModels.generateFlatItem(ModItems.RAW_ONYX.get(), ModelTemplates.FLAT_ITEM);
        blockModels.createTrivialCube(ModBlocks.RAW_ONYX_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.ONYX_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.POLISHED_ONYX_BLOCK.get());
        itemModels.generateFlatItem(ModItems.ONYX.get(), ModelTemplates.FLAT_ITEM);

        // Shadowite
        blockModels.createTrivialCube(ModBlocks.SHADOWITE.get());
        itemModels.generateFlatItem(ModItems.SHADOWITE_SHARD.get(), ModelTemplates.FLAT_ITEM);

        // Sunstone
        blockModels.createTrivialCube(ModBlocks.SUNSTONE.get());
        itemModels.generateFlatItem(ModItems.SOLAR_SHARD.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.FROSTITE.get());
        blockModels.createTrivialCube(ModBlocks.VOID_STONE.get());

        // Bow
        itemModels.generateBow(ModItems.CRUDE_BOW.get());

        // Azurite blocks
        blockModels.createTrivialCube(ModBlocks.AZURITE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_END_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_AZURITE_BLOCK.get());

        // Pink Garnet blocks
        blockModels.createTrivialCube(ModBlocks.PINK_GARNET_ORE.get());
        blockModels.createTrivialCube(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.PINK_GARNET_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.PINK_GARNET_END_ORE.get());
        blockModels.createTrivialCube(ModBlocks.RAW_PINK_GARNET_BLOCK.get());


        blockModels.createTrivialCube(ModBlocks.STORM_QUARTZ_ORE.get());
        blockModels.createTrivialCube(ModBlocks.STORM_QUARTZ_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.POLISHED_STORM_QUARTZ_ORE.get());


        // Magic block
        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());

        // Block families (handles base block + stairs + slab models)
        blockModels.family(ModBlocks.AZURITE_BLOCK.get())
                .stairs(ModBlocks.AZURITE_STAIRS.get())
                .slab(ModBlocks.AZURITE_SLAB.get());

        blockModels.family(ModBlocks.PINK_GARNET_BLOCK.get())
                .stairs(ModBlocks.PINK_GARNET_STAIRS.get())
                .slab(ModBlocks.PINK_GARNET_SLAB.get());
    }
}