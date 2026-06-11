package net.fahim.fahimsrpgmod.item;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.food.ModFoods;
import net.fahim.fahimsrpgmod.item.custom.ChiselItem;
import net.fahim.fahimsrpgmod.item.custom.CrudeBowItem;
import net.fahim.fahimsrpgmod.item.custom.MetalDectectorItem;

import net.fahim.fahimsrpgmod.item.custom.ModArmorMaterials;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FahimsRPGMod.MOD_ID);

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");
    public static final DeferredItem<Item> RAW_PINK_GARNET = ITEMS.registerSimpleItem("raw_pink_garnet");
    public static final DeferredItem<Item> PINK_GARNET = ITEMS.registerSimpleItem("pink_garnet");

   public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector",
           properties -> new MetalDectectorItem(properties.durability(100)));

   public static final DeferredItem<Item> CHISEL_ITEM = ITEMS.registerItem("chisel_item",
           properties -> new ChiselItem(properties.durability(100)));

    public static final DeferredItem<Item> CRUDE_BOW = ITEMS.registerItem("crude_bow",
            properties -> new CrudeBowItem(properties.durability(500)));

    //GARNET ARMOUR
    public static final DeferredItem<Item> PINK_GARNET_HELMET = ITEMS.registerItem(
            "pink_garnet_helmet",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorType.HELMET))
    );

    public static final DeferredItem<Item> PINK_GARNET_CHESTPLATE = ITEMS.registerItem(
            "pink_garnet_chestplate",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorType.CHESTPLATE))
    );

    public static final DeferredItem<Item> PINK_GARNET_LEGGINGS = ITEMS.registerItem(
            "pink_garnet_leggings",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorType.LEGGINGS))
    );

    public static final DeferredItem<Item> PINK_GARNET_BOOTS = ITEMS.registerItem(
            "pink_garnet_boots",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorType.BOOTS))
    );

    //AZURITE ARMOUR
    public static final DeferredItem<Item> AZURITE_HELMET = ITEMS.registerItem(
            "azurite_helmet",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.HELMET))
    );

    public static final DeferredItem<Item> AZURITE_CHESTPLATE = ITEMS.registerItem(
            "azurite_chestplate",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE))
    );

    public static final DeferredItem<Item> AZURITE_LEGGINGS = ITEMS.registerItem(
            "azurite_leggings",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.LEGGINGS))
    );

    public static final DeferredItem<Item> AZURITE_BOOTS = ITEMS.registerItem(
            "azurite_boots",
            props -> new Item(props.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.BOOTS))
    );























































    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.fahimsrpgmod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

public static final DeferredItem<Item> END_FIRE = ITEMS.registerItem("end_fire",
            properties -> new Item(properties.stacksTo(32)));

public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.registerItem("starlight_ashes",
            properties -> new Item(properties.stacksTo(32)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
