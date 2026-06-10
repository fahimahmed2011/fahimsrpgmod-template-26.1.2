package net.fahim.fahimsrpgmod.client;

import net.fahim.fahimsrpgmod.item.custom.CrudeBowItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(modid = "fahimsrpgmod", value = Dist.CLIENT)
public class ModHudRenderer {

    private static float currentCharge = 0f;

    @SubscribeEvent
    public static void onRenderHud(RenderGuiEvent.Post event) {
        System.out.println("HUD firing, charge: " + currentCharge); // ADD THIS
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getMainHandItem();
        boolean isDrawing = mc.player.isUsingItem() && stack.getItem() instanceof CrudeBowItem;
        System.out.println("isUsing: " + mc.player.isUsingItem() + " | isBow: " + (stack.getItem() instanceof CrudeBowItem));

        if (isDrawing) {
            currentCharge = Math.min(currentCharge + 0.05f, 1f);
        } else {
            currentCharge = Math.max(currentCharge - 0.1f, 0f);
        }

        if (currentCharge <= 0f) return;

        int screenW = mc.getWindow().getGuiScaledWidth();
        int screenH = mc.getWindow().getGuiScaledHeight();
        int barHeight = (int)(screenH * 0.30f * currentCharge);

        event.getGuiGraphics().fill(0, 0, screenW, barHeight, 0xFF000000);
        event.getGuiGraphics().fill(0, screenH - barHeight, screenW, screenH, 0xFF000000);
    }

    @SubscribeEvent
    public static void onFovModifier(ComputeFovModifierEvent event) {
        // Zoom in up to 30% at full charge (0.7 = 30% narrower FOV)
        float zoomFactor = 1f - (currentCharge * 0.5f);
        event.setNewFovModifier(event.getFovModifier() * zoomFactor);
    }
}