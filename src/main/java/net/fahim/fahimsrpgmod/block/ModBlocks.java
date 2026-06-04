package net.fahim.fahimsrpgmod.block;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(FahimsRPGMod.MOD_ID);

public static final DeferredBlock<Block> AZURITE_BLOCK =  registerblock("azurite_block",
        properties -> new Block(properties.strength(4f)
                .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PINK_GARNET_BLOCK =  registerblock("pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RAW_PINK_GARNET_BLOCK =  registerblock("raw_pink_garnet_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));



private static <T extends Block> DeferredBlock<T> registerblock(String name, Function<BlockBehaviour.Properties, T> function){
    DeferredBlock<T> toReturn = BLOCKS.registerBlock(name,function);
    return toReturn;
}

private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T>block){
    ModItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(),properties.useBlockDescriptionPrefix()));
}


    public static void register (IEventBus eventBus){
    BLOCKS.register(eventBus);
    }
}
