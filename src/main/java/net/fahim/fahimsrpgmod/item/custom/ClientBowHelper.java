package net.fahim.fahimsrpgmod.item.custom;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientBowHelper {

    public static void applyZoom(int ticksUsed) {
        Minecraft mc = Minecraft.getInstance();
        float progress = Math.min((ticksUsed - 10) / 10f, 1f);
        mc.options.fov().set((int)(70 - (20 * progress)));
    }

    public static void resetZoom() {
        Minecraft.getInstance().options.fov().set(70);
    }
}