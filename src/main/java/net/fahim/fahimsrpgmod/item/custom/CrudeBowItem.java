package net.fahim.fahimsrpgmod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;



public class CrudeBowItem extends BowItem {

    public CrudeBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity entity, @NotNull ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, entity, stack, remainingUseDuration);

        if (level.isClientSide() && entity instanceof Player player) {
            int ticksUsed = getUseDuration(stack, entity) - remainingUseDuration;
            if (ticksUsed > 10) {
                applyZoomEffect(ticksUsed);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void applyZoomEffect(int ticksUsed) {
        Minecraft mc = Minecraft.getInstance();
        float progress = Math.min((ticksUsed - 10) / 10f, 1f);
        mc.options.fov().set((int)(70 - (20 * progress)));
    }

    @Override
    public boolean releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity, int timeCharged) {
        boolean result = super.releaseUsing(stack, level, entity, timeCharged);

        if (level.isClientSide()) {
            resetZoom();
        }

        return result;
    }

    @OnlyIn(Dist.CLIENT)
    private void resetZoom() {
        Minecraft.getInstance().options.fov().set(70);
    }
}