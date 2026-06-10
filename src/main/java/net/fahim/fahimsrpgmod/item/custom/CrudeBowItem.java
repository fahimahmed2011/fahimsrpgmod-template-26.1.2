package net.fahim.fahimsrpgmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.fahim.fahimsrpgmod.item.custom.ClientBowHelper;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

public class CrudeBowItem extends BowItem {

    public CrudeBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity entity, @NotNull ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, entity, stack, remainingUseDuration);

        if (level.isClientSide() && entity instanceof Player) {
            int ticksUsed = getUseDuration(stack, entity) - remainingUseDuration;
            if (ticksUsed > 10) {
                ClientBowHelper.applyZoom(ticksUsed);
            }
        }
    }

    @Override
    public boolean releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity, int timeCharged) {
        boolean result = super.releaseUsing(stack, level, entity, timeCharged);

        if (level.isClientSide()) {
            ClientBowHelper.resetZoom();
        }

        return result;
    }
}