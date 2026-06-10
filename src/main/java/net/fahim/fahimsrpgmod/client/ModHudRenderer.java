package net.fahim.fahimsrpgmod.client;

import net.fahim.fahimsrpgmod.item.custom.CrudeBowItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(modid = "fahimsrpgmod", value = Dist.CLIENT)
public class ModHudRenderer {

    @SubscribeEvent
    public static void onRenderHud(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getUseItem();
        if (!(stack.getItem() instanceof CrudeBowItem)) return;

        int ticksUsed = mc.player.getTicksUsingItem();
        if (ticksUsed <= 0) return;

        float charge = Math.min(ticksUsed / 20f, 1f);
        int barWidth = (int)(100 * charge);

        int screenW = mc.getWindow().getGuiScaledWidth();
        int screenH = mc.getWindow().getGuiScaledHeight();

        event.getGuiGraphics().fill(
                screenW / 2 - 50,
                screenH - 30,
                screenW / 2 - 50 + barWidth,
                screenH - 24,
                0xFF00FF00
        );
    }
}