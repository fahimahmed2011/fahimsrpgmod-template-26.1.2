package net.fahim.fahimsrpgmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MeatalDectectorItem extends Item {
    public MeatalDectectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos positionClicked = context.getClickedPos();
        Player player = context.getPlayer();

        if (!level.isClientSide()) {
            boolean foundBlock = false;
            for (int i = 0; i<= positionClicked.getY()+64;i++){

            }

        }


        return InteractionResult.SUCCESS;
    }
}
