package net.fahim.fahimsrpgmod.item.custom;

import com.google.common.collect.Maps;
import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class ModArmorMaterials {

    public static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(
            Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> PINK_GARNET_KEY = ResourceKey.create(
            ROOT_ID, Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "pink_garnet"));

    public static final ArmorMaterial PINK_GARNET_ARMOR_MATERIAL = new ArmorMaterial(
            25,
            makeDefense(5, 7, 8, 6, 7),
            18,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            1.5f,
            0.0f,
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "repairs_pink_garnet_armor")),
            PINK_GARNET_KEY
    );
    public static final ResourceKey<EquipmentAsset> AZURITE_KEY = ResourceKey.create(
            ROOT_ID, Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "azurite"));

    public static final ArmorMaterial AZURITE_ARMOR_MATERIAL = new ArmorMaterial(
            20,
            makeDefense(3, 6, 8, 4, 5),
            18,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            1.5f,
            0.0f,
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "repairs_azurite_armor")),
            AZURITE_KEY);


    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs,
                ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}