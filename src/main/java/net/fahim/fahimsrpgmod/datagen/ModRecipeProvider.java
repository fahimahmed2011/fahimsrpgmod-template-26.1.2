package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }


    public static class Runner extends RecipeProvider.Runner{

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "FahimsRPGMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        // PINK GARNET BLOCK COMPRESS / DECOMPRESS
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PINK_GARNET.get())
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.PINK_GARNET.get(), 9)
                .requires(ModBlocks.PINK_GARNET_BLOCK)
                .unlockedBy(getHasName(ModBlocks.PINK_GARNET_BLOCK.get()), has(ModBlocks.PINK_GARNET_BLOCK))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 18)
                .requires(ModBlocks.AZURITE_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output, "fahimsrpgmod:azurite_from_blaze_powder");

        List<ItemLike> AZURITE_SMELTABLES = List.of
                (ModItems.RAW_AZURITE,
                ModBlocks.AZURITE_ORE,
                ModBlocks.AZURITE_DEEPSLATE_ORE,
                ModBlocks.AZURITE_NETHER_ORE,
                ModBlocks.AZURITE_END_ORE);

        oreSmelting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 200, "azurite");
        oreBlasting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 100, "azurite");

        List<ItemLike> PINK_GARNET_SMELTABLES = List.of(
                ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE,
                ModBlocks.PINK_GARNET_NETHER_ORE,
                ModBlocks.PINK_GARNET_END_ORE
        );

        oreSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PINK_GARNET.get(), 0.25f, 200, "pink_garnet");
        oreBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.PINK_GARNET.get(), 0.25f, 100, "pink_garnet");

        stairBuilder(ModBlocks.AZURITE_STAIRS.get(),Ingredient.of(ModBlocks.AZURITE_BLOCK))
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output);
        slab(RecipeCategory.BUILDING_BLOCKS,ModBlocks.AZURITE_SLAB.get(),ModBlocks.AZURITE_BLOCK.get());


        stairBuilder(ModBlocks.PINK_GARNET_STAIRS.get(),Ingredient.of(ModBlocks.PINK_GARNET_BLOCK))
                .unlockedBy(getHasName(ModBlocks.PINK_GARNET_BLOCK.get()), has(ModBlocks.PINK_GARNET_BLOCK))
                .group("pink_garnet")
                .save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB.get(), ModBlocks.PINK_GARNET_BLOCK.get());


        shaped(RecipeCategory.COMBAT, ModItems.PINK_GARNET_HELMET.get())
                .pattern("PPP")
                .pattern("P P")
                .define('P', ModItems.PINK_GARNET.get())
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.PINK_GARNET_CHESTPLATE.get())
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PINK_GARNET.get())
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.PINK_GARNET_LEGGINGS.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .define('P', ModItems.PINK_GARNET.get())
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.PINK_GARNET_BOOTS.get())
                .pattern("P P")
                .pattern("P P")
                .define('P', ModItems.PINK_GARNET.get())
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .save(output);
//AZURITE
        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .save(output);


        // PINK GARNET TOOLS & WEAPONS
        shaped(RecipeCategory.COMBAT, ModItems.GARNETS_WRATH.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.GARNET_CLEAVER.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.GARNET_CRUSHER.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.GARNET_DELVER.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.GARNET_TILLER.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.GARNET_IMPALER.get())
                .pattern(" P")
                .pattern("PS")
                .pattern("S ")
                .define('P', ModItems.PINK_GARNET.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PINK_GARNET.get()), has(ModItems.PINK_GARNET))
                .group("pink_garnet")
                .save(output);

        // AZURITE TOOLS & WEAPONS
        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.AZURITE_AXE.get())
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.AZURITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.AZURITE_SHOVEL.get())
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.AZURITE_HOE.get())
                .pattern("AA")
                .pattern(" S")
                .pattern(" S")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.AZURITE_SPEAR.get())
                .pattern(" A")
                .pattern("AS")
                .pattern("S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, FahimsRPGMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}

