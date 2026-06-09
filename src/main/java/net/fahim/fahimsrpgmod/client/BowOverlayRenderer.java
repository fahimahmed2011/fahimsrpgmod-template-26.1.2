package net.fahim.fahimsrpgmod.client;

import net.fahim.fahimsrpgmod.item.custom.CrudeBowItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(modid = "fahimsrpgmod", value = Dist.CLIENT)
public class BowOverlayRenderer {

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getUseItem();
        if (!(stack.getItem() instanceof CrudeBowItem)) return;

        int ticksUsed = mc.player.getTicksUsingItem();
        if (ticksUsed <= 10) return;

        float progress = Math.min((ticksUsed - 10) / 10f, 1f);
        int barHeight = (int)(mc.getWindow().getGuiScaledHeight() * 0.12f * progress);

        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        // top bar
        event.getGuiGraphics().fill(0, 0, screenWidth, barHeight, 0xFF000000);
        // bottom bar
        event.getGuiGraphics().fill(0, screenHeight - barHeight, screenWidth, screenHeight, 0xFF000000);
    }
}