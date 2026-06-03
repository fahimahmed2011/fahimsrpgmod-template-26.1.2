package net.fahim.fahimsrpgmod;

import net.fahim.fahimsrpgmod.datagen.ModModelprovider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = FahimsRPGMod.MOD_ID)
public class FahimsRPGModDataGen {
@SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packOutput = generator.getPackOutput();


    generator.addProvider(true,new ModModelprovider(packOutput));

    }
}
