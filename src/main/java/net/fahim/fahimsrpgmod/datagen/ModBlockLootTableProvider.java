package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //Moon
        add(ModBlocks.MOON_STONE.get(),
                createMultipleOreDrops(ModBlocks.MOON_STONE.get(), ModItems.MOON_SHARD.get(), 1, 3));

        //Lightning
        dropSelf(ModBlocks.STORM_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_STORM_QUARTZ_ORE.get());
        add(ModBlocks.STORM_QUARTZ_ORE.get(),
                createMultipleOreDrops(ModBlocks.STORM_QUARTZ_ORE.get(), ModItems.STORM_QUARTZ.get(), 1, 3));

        // Azurite
        dropSelf(ModBlocks.AZURITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_AZURITE_BLOCK.get());
        dropSelf(ModBlocks.AZURITE_STAIRS.get());
        add(ModBlocks.AZURITE_SLAB.get(), this::createSlabItemTable);
        add(ModBlocks.AZURITE_ORE.get(),
                createOreDrop(ModBlocks.AZURITE_ORE.get(), ModItems.RAW_AZURITE.get()));
        add(ModBlocks.AZURITE_NETHER_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITE_NETHER_ORE.get(), ModItems.RAW_AZURITE.get(), 4, 7));
        add(ModBlocks.AZURITE_END_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITE_END_ORE.get(), ModItems.RAW_AZURITE.get(), 4, 7));

        // Pink Garnet
        dropSelf(ModBlocks.PINK_GARNET_BLOCK.get());
        dropSelf(ModBlocks.RAW_PINK_GARNET_BLOCK.get());
        dropSelf(ModBlocks.PINK_GARNET_STAIRS.get());
        add(ModBlocks.PINK_GARNET_SLAB.get(), this::createSlabItemTable);
        add(ModBlocks.PINK_GARNET_ORE.get(),
                createMultipleOreDrops(ModBlocks.PINK_GARNET_ORE.get(), ModItems.RAW_PINK_GARNET.get(), 4, 5));
        add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get(),
                createMultipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.get(), ModItems.RAW_PINK_GARNET.get(), 4, 5));
        add(ModBlocks.PINK_GARNET_NETHER_ORE.get(),
                createMultipleOreDrops(ModBlocks.PINK_GARNET_NETHER_ORE.get(), ModItems.RAW_PINK_GARNET.get(), 4, 5));
        add(ModBlocks.PINK_GARNET_END_ORE.get(),
                createMultipleOreDrops(ModBlocks.PINK_GARNET_END_ORE.get(), ModItems.RAW_PINK_GARNET.get(), 4, 5));

        // Onyx
        dropSelf(ModBlocks.ONYX_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_ONYX_BLOCK.get());
        dropSelf(ModBlocks.RAW_ONYX_BLOCK.get());
        add(ModBlocks.ONYX_ORE.get(),
                createMultipleOreDrops(ModBlocks.ONYX_ORE.get(), ModItems.RAW_ONYX.get(), 2, 5));

        // Misc blocks
        dropSelf(ModBlocks.SHADOWITE.get());
        dropSelf(ModBlocks.SUNSTONE.get());
        dropSelf(ModBlocks.FROSTITE.get());
        dropSelf(ModBlocks.VOID_STONE.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.CAULIFLOWER_CROP.get(), createCropDrops(ModBlocks.CAULIFLOWER_CROP.get(),
                ModItems.CAULIFLOWER.get(), ModItems.CAULIFLOWER_SEEDS.get(),
                net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CAULIFLOWER_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CropBlock.AGE, 6))));

    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}