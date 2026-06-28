package net.fahim.fahimsrpgmod;

import com.mojang.logging.LogUtils;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.blockentity.ModBlockEntities;
import net.fahim.fahimsrpgmod.creativemodetab.ModCreativeModeTabs;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(FahimsRPGMod.MOD_ID)
public class FahimsRPGMod {

    public static final String MOD_ID = "fahimsrpgmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FahimsRPGMod(IEventBus modEventBus, ModContainer modContainer) {

        // Setup events
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        // Register mod content
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Fahim's RPG Mod common setup loaded!");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("CLIENT SETUP CALLED");

            Minecraft.getInstance().getWindow().setTitle("⚔ Fahim's RPG Mod ⚔");
        });
    }
}