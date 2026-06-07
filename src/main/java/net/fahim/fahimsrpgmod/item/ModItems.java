package net.fahim.fahimsrpgmod.item;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.item.custom.MetalDectectorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FahimsRPGMod.MOD_ID);

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");
    public static final DeferredItem<Item> RAW_PINK_GARNET = ITEMS.registerSimpleItem("raw_pink_garnet");
    public static final DeferredItem<Item> PINK_GARNET = ITEMS.registerSimpleItem("pink_garnet");

   public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("meatal_detector",
           properties -> new MetalDectectorItem(properties.durability(100)));

   public static final DeferredItem<Item> CHISEL_ITEM = ITEMS.registerItem("chisel_item",
           properties -> new MetalDectectorItem(properties.durability(100)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
