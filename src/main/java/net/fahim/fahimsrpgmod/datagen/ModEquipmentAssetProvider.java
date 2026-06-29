package net.fahim.fahimsrpgmod.datagen;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.item.ModArmorMaterials;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(net.fahim.fahimsrpgmod.item.ModArmorMaterials.AZURITE_KEY, EquipmentClientInfo.builder()
                .addHumanoidLayers(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "azurite"), false)
                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY,
                        new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "azurite")))
                .build());

        output.accept(ModArmorMaterials.PINK_GARNET_KEY, EquipmentClientInfo.builder()
                .addHumanoidLayers(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "pink_garnet"), false)
                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY,
                        new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(FahimsRPGMod.MOD_ID, "pink_garnet")))
                .build());


    }




    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "TutorialMod Equipment Definitions";
    }
}