package net.fahim.fahimsrpgmod;

import net.neoforged.bus.api.Event;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.neoforged.bus.api.IEventBus;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;



@Mod(FahimsRPGMod.MOD_ID)
public class FahimsRPGMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fahimsrpgmod";

    public static final Logger LOGGER = LogUtils.getLogger();

    public FahimsRPGMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);


        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }




    private void commonSetup(FMLCommonSetupEvent event) {
    }
}

