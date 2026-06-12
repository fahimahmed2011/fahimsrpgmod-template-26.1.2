package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.fahim.fahimsrpgmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, FahimsRPGMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.IRON_INGOT)
                .add(Items.REDSTONE)
                .add(Items.COPPER_INGOT)
                .add(ModItems.PINK_GARNET.get());

        tag(ModTags.Items.AZURITE_REPAIRABLE)
                .add(ModItems.AZURITE.get());

        tag(ModTags.Items.PINK_GARNET_REPAIRABLE)
                .add(ModItems.PINK_GARNET.get());
    }
}
