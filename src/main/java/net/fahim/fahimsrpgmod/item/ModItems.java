package net.fahim.fahimsrpgmod.item;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.food.ModFoods;
import net.fahim.fahimsrpgmod.item.custom.*;
import net.fahim.fahimsrpgmod.item.custom.ScytheItem;

import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FahimsRPGMod.MOD_ID);

    //Moon
    public static final DeferredItem<Item> MOON_SHARD = ITEMS.registerSimpleItem("moon_shard");

    public static final DeferredItem<Item> CAULIFLOWER = ITEMS.registerItem("cauliflower",
            properties -> new Item(properties.food(ModFoods.CAULIFLOWER, ModFoods.CAULIFLOWER_CONSUMABLE)));

    public static final DeferredItem<Item> CAULIFLOWER_SEEDS = ITEMS.registerItem("cauliflower_seeds",
            properties -> new BlockItem(ModBlocks.CAULIFLOWER_CROP.get(), properties));

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");
    public static final DeferredItem<Item> RAW_PINK_GARNET = ITEMS.registerSimpleItem("raw_pink_garnet");
    public static final DeferredItem<Item> PINK_GARNET = ITEMS.registerSimpleItem("pink_garnet");

    public static final DeferredItem<Item> RAW_ONYX = ITEMS.registerSimpleItem("raw_onyx");
    public static final DeferredItem<Item> ONYX = ITEMS.registerSimpleItem("onyx");

    public static final DeferredItem<Item> SOLAR_SHARD = ITEMS.registerSimpleItem("solar_shard");

    public static final DeferredItem<Item> SHADOWITE_SHARD = ITEMS.registerSimpleItem("shadowite_shard");

    public static final DeferredItem<Item> STORM_QUARTZ = ITEMS.registerSimpleItem("storm_quartz");

    public static final DeferredItem<Item> RAW_STORM_QUARTZ = ITEMS.registerSimpleItem("raw_storm_quartz");


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
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE))
            {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.fahimsrpgmod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

public static final DeferredItem<Item> END_FIRE = ITEMS.registerItem("end_fire",
            properties -> new Item(properties.stacksTo(32)));

public static final DeferredItem<Item> AZURITE_SWORD = ITEMS.registerItem("azurite_sword",
            properties -> new Item(properties.sword(ModToolTiers.AZURITE,4,-2.4f)));

public static final DeferredItem<Item> AZURITE_PICKAXE = ITEMS.registerItem("azurite_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.AZURITE,1,-2.6f)));

public static final DeferredItem<Item> AZURITE_AXE = ITEMS.registerItem("azurite_axe",
            properties -> new AxeItem(ModToolTiers.AZURITE,7,-2.4f,properties));

public static final DeferredItem<Item> AZURITE_HOE = ITEMS.registerItem("azurite_hoe",
            properties -> new HoeItem(ModToolTiers.AZURITE,0,-2.4f,properties));

public static final DeferredItem<Item> AZURITE_SHOVEL = ITEMS.registerItem("azurite_shovel",
            properties -> new ShovelItem(ModToolTiers.AZURITE,1.6f,-2.4f,properties));

public static final DeferredItem<Item> AZURITE_SPEAR = ITEMS.registerItem("azurite_spear",
            properties -> new Item(properties.spear(ModToolTiers.AZURITE,0.96f,0.7f,0.8f,
                    3.5f,13f,8.5f,5.1f,13.37f,14.67f)));


public static final DeferredItem<Item> GARNETS_WRATH = ITEMS.registerItem("garnets_wrath",
            properties -> new Item(properties.sword(ModToolTiers.PINK_GARNET,6,-2.2f)));

public static final DeferredItem<Item> GARNET_CLEAVER = ITEMS.registerItem("garnet_cleaver",
            properties -> new AxeItem(ModToolTiers.PINK_GARNET,8,-2.2f,properties));

public static final DeferredItem<Item> GARNET_PICKAXE = ITEMS.registerItem("garnet_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.PINK_GARNET,2,-2.2f)));

public static final DeferredItem<Item> GARNET_DELVER = ITEMS.registerItem("garnet_delver",
            properties -> new ShovelItem(ModToolTiers.PINK_GARNET,1.7f,-2.2f,properties));

public static final DeferredItem<Item> GARNET_TILLER = ITEMS.registerItem("garnet_tiller",
            properties -> new HoeItem(ModToolTiers.PINK_GARNET,0,-2.2f,properties));

    public static final DeferredItem<ScytheItem> GARNET_SCYTHE = ITEMS.registerItem("garnet_scythe",
            properties -> new ScytheItem(properties
                    .sword(ModToolTiers.PINK_GARNET, 5, -3.0f)
                    .durability(1500)
            )
    );


//public static final DeferredItem<Item> GARNET_IMPALER = ITEMS.registerItem("garnet_impaler",
           // properties -> new Item(properties.spear(ModToolTiers.PINK_GARNET,1f,-2.2f,0.5f,
                //    3.1f,14f,8.7f,5.7f,14f,14f)));


public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.registerItem("starlight_ashes",
            properties -> new Item(properties.stacksTo(32)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
