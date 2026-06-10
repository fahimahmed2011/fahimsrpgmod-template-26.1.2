package net.fahim.fahimsrpgmod.client;

import net.fahim.fahimsrpgmod.item.custom.CrudeBowItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;

@EventBusSubscriber(modid = "fahimsrpgmod", value = Dist.CLIENT)
public class ModHudRenderer {

    private static float currentCharge = 0f;

    @SubscribeEvent
    public static void onRenderHud(RenderGuiLayerEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getMainHandItem();
        boolean isDrawing = mc.player.isUsingItem() && stack.getItem() instanceof CrudeBowItem;

        if (isDrawing) {
            currentCharge = Math.min(currentCharge + 0.05f, 1f);
        } else {
            currentCharge = Math.max(currentCharge - 0.1f, 0f);
        }

        if (currentCharge <= 0f) return;

        int screenW = mc.getWindow().getGuiScaledWidth();
        int screenH = mc.getWindow().getGuiScaledHeight();
        int barHeight = (int)(screenH * 0.15f * currentCharge);

        event.getGuiGraphics().fill(0, 0, screenW, barHeight, 0xFF000000);
        event.getGuiGraphics().fill(0, screenH - barHeight, screenW, screenH, 0xFF000000);
    }
}