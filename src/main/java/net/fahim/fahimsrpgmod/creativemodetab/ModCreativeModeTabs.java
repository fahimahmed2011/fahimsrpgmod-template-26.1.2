package net.fahim.fahimsrpgmod.creativemodetab;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FahimsRPGMod.MOD_ID);


    public static final Supplier<CreativeModeTab>PINK_GARNET_BLOCK = CREATIVE_MODE_TABS.register("pink_garnet_blocks_tab",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.PINK_GARNET_BLOCK.get()))
                    .title(Component.translatable("creativetab.fahimsrpgmod.pink_garnet_items"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID,"azurite_blocks_tab")).displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.PINK_GARNET_BLOCK);
                      output.accept(ModBlocks.PINK_GARNET_ORE);
                      output.accept(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);


                    }).build());


    public static final Supplier<CreativeModeTab>PINK_GARNET_ITEMS = CREATIVE_MODE_TABS.register("pink_garnet_items_tab",
            ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItems.PINK_GARNET.get()))
                    .title(Component.translatable("creativetab.fahimsrpgmod.pink_garnet_items"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID,"pink_garnet_blocks_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PINK_GARNET);
                        output.accept(ModItems.RAW_PINK_GARNET);



                    }).build());

    public static final Supplier<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
    ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.AZURITE.get()))
            .title(Component.translatable("creativetab.fahimsrpgmod.azurite_items"))
            .withTabsAfter(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID,"azurite_blocks_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.AZURITE);
                output.accept(ModItems.RAW_AZURITE);




            }).build());

    public static final Supplier<CreativeModeTab> AZURITE_BLOCKS_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_blocks_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.fahimsrpgmod.azurite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AZURITE_BLOCK);
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK);

                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.AZURITE_ORE);
                        output.accept(ModBlocks.AZURITE_END_ORE);
                        output.accept(ModBlocks.AZURITE_NETHER_ORE);






                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
