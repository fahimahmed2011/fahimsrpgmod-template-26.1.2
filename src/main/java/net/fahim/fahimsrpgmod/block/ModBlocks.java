package net.fahim.fahimsrpgmod.block;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.custom.MagicBlock;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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

public static final DeferredBlock<Block> PINK_GARNET_NETHER_ORE =  registerblock("pink_garnet_nether_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));

public static final DeferredBlock<Block> PINK_GARNET_END_ORE =  registerblock("pink_garnet_end_ore",
        properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.STONE)));

public static final DeferredBlock<Block> AZURITE_DEEPSLATE_ORE =  registerblock("azurite_deepslate_ore",
        properties -> new DropExperienceBlock(UniformInt.of(5,6),properties.strength(7f)
                .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> PINK_GARNET_BLOCK =  registerblock("pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RAW_PINK_GARNET_BLOCK =  registerblock("raw_pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PINK_GARNET_ORE =  registerblock("pink_garnet_ore",
            properties -> new Block(properties.strength(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PINK_GARNET_DEEPSLATE_ORE =  registerblock("pink_garnet_deepslate_ore",
            properties -> new Block(properties.strength(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //public static final DeferredBlock<Block> SHADOWITE =  registerblock("shadowite",
//properties -> new Block(properties.strength(6f)
                  //  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //public static final DeferredBlock<Block> SUNSTONE =  registerblock("sunstone",
          //  properties -> new Block(properties.strength(6f)
                   // .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

   // public static final DeferredBlock<Block> FROSTITE =  registerblock("frostite",
            //properties -> new Block(properties.strength(6f)
                  //  .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

   // public static final DeferredBlock<Block> VOID_STONE =  registerblock("void_stone",
          //  properties -> new Block(properties.strength(6f)
                //   .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerblock("magic_block",
            properties -> new MagicBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.DECORATED_POT)),Component.translatable("tooltip.fahimsrpgmod.magic_block.tooltip"));

    public static final DeferredBlock<Block> AZURITE_STAIRS = registerblock("azurite_stairs",
            properties -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> PINK_GARNET_STAIRS = registerblock("pink_garnet_stairs",
            properties -> new StairBlock(ModBlocks.PINK_GARNET_BLOCK.get().defaultBlockState(),properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

 public static final DeferredBlock<Block> AZURITE_SLAB = registerblock("azurite-slab",
            properties -> new SlabBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
 public static final DeferredBlock<Block> PINK_GARNET_SLAB = registerblock("pink_garnet_slab",
            properties -> new SlabBlock(properties.strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));






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
