package net.fahim.fahimsrpgmod.tags;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_DETECTABLES = createTag("metal_detectables");

        public static final TagKey<Block> NEEDS_AZURITE_TOOL = createTag("needs_azurite_tool");
        public static final TagKey<Block> INCORRECT_FOR_AZURITE_TOOL = createTag("incorrect_for_azurite_tool");

        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");


        private static TagKey<Block> createTag(String name){
            return BlockTags.create(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, name));
        }
    }


public static class Items {
    public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
    public static final TagKey<Item> AZURITE_REPAIRABLE = createTag("azurite_repairable");
    public static final TagKey<Item> PINK_GARNET_REPAIRABLE = createTag("pink_garnet_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, name));
        }
    }
}
