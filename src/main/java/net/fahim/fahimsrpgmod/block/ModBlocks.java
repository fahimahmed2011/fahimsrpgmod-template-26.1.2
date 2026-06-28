package net.fahim.fahimsrpgmod.block;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.custom.CauliflowerCropBlock;
import net.fahim.fahimsrpgmod.block.custom.MagicBlock;
import net.fahim.fahimsrpgmod.block.custom.MoonStoneBlock;
import net.fahim.fahimsrpgmod.block.custom.StormQuartzOreBlock;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(FahimsRPGMod.MOD_ID);

public static final DeferredBlock<Block> AZURITE_BLOCK =  registerblock("azurite_block",
        properties -> new Block(properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
public static final DeferredBlock<Block> RAW_AZURITE_BLOCK =  registerblock("raw_azurite_block",
        properties -> new Block(properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
public static final DeferredBlock<Block> AZURITE_ORE =  registerblock("azurite_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));
public static final DeferredBlock<Block> AZURITE_END_ORE =  registerblock("azurite_end_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));
public static final DeferredBlock<Block> AZURITE_NETHER_ORE =  registerblock("azurite_nether_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));



    public static final DeferredBlock<Block> STORM_QUARTZ_ORE = registerblock("storm_quartz_ore",
            properties -> new StormQuartzOreBlock(properties.strength(7f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> STORM_QUARTZ_BLOCK = registerblock("storm_quartz_block",
            properties -> new StormQuartzOreBlock(properties.strength(7f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

public static final DeferredBlock<Block> POLISHED_STORM_QUARTZ_ORE = registerblock("polished_storm_quartz_block",
            properties -> new StormQuartzOreBlock(properties.strength(7f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PINK_GARNET_BLOCK =  registerblock("pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_PINK_GARNET_BLOCK =  registerblock("raw_pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> PINK_GARNET_ORE =  registerblock("pink_garnet_ore",
            properties ->  new DropExperienceBlock(UniformInt.of(2, 5), properties.strength(3.0f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> PINK_GARNET_DEEPSLATE_ORE =  registerblock("pink_garnet_deepslate_ore",
            properties ->  new DropExperienceBlock(UniformInt.of(2, 5), properties.strength(3.0f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> PINK_GARNET_NETHER_ORE =  registerblock("pink_garnet_nether_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PINK_GARNET_END_ORE =  registerblock("pink_garnet_end_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> ONYX_ORE = registerblock("onyx_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5), properties.strength(21.3f, 1200f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> RAW_ONYX_BLOCK = registerblock("raw_onyx_block",
            properties -> new Block(properties.strength(6.0f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ONYX_BLOCK = registerblock("onyx_block",
            properties -> new Block(properties.strength(10.0f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> POLISHED_ONYX_BLOCK = registerblock("polished_onyx_block",
            properties -> new Block(properties.strength(15.0f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SHADOWITE =  registerblock("shadowite",
properties -> new Block(properties.strength(6f)
                  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
//Moon Stone
    public static final DeferredBlock<Block> MOON_STONE =  registerblock("moon_stone",
properties -> new MoonStoneBlock(properties.strength(6f).randomTicks()
        .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    //Stone Crystal Ore
    public static final DeferredBlock<Block> STONE_CRYSTAL_ORE =  registerblock("stone_crystal_ore",
properties -> new Block(properties.strength(6f)
                  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    //Mythril Ore
    public static final DeferredBlock<Block> MYTHRIL_ORE =  registerblock("mythril_ore",
properties -> new Block(properties.strength(6f)
                  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> SUNSTONE =  registerblock("sunstone",
            properties -> new Block(properties.strength(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> FROSTITE =  registerblock("frostite",
            properties -> new Block(properties.strength(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> VOID_STONE =  registerblock("void_stone",
           properties -> new Block(properties.strength(6f)
                  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> MAGIC_BLOCK = registerblock("magic_block",
            properties -> new MagicBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.DECORATED_POT)),Component.translatable("tooltip.fahimsrpgmod.magic_block.tooltip"));

    public static final DeferredBlock<Block> AZURITE_STAIRS = registerblock("azurite_stairs",
            properties -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
 public static final DeferredBlock<Block> AZURITE_SLAB = registerblock("azurite_slab",
            properties -> new SlabBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


 public static final DeferredBlock<Block> PINK_GARNET_SLAB = registerblock("pink_garnet_slab",
            properties -> new SlabBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> PINK_GARNET_STAIRS = registerblock("pink_garnet_stairs",
            properties -> new StairBlock(ModBlocks.PINK_GARNET_BLOCK.get().defaultBlockState(),properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> CAULIFLOWER_CROP = registerblock("cauliflower_crop",
            properties -> new CauliflowerCropBlock(properties
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)));





        private static <T extends Block> DeferredBlock<T> registerblock(String name, Function<BlockBehaviour.Properties, T> function, Component...components){
         DeferredBlock<T> toReturn = BLOCKS.registerBlock(name,function);
          registerBlockItem(name, toReturn,components);
          return toReturn;
         }

         private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T>block, Component...components) {
             ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()){
                 @Override
                 public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                     for (var compponent : components){
                         builder.accept(compponent);
                     }
                     super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                 }
             });


         }       private static <T extends Block> DeferredBlock<T> registerblock(String name, Function<BlockBehaviour.Properties, T> function){
         DeferredBlock<T> toReturn = BLOCKS.registerBlock(name,function);
         registerBlockItem(name, toReturn);
          return toReturn;
         }

       private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T>block){
       ModItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(),properties.useBlockDescriptionPrefix()));
        }


       public static void register (IEventBus eventBus){
      BLOCKS.register(eventBus);
    }
}
