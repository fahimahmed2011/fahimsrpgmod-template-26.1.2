package net.fahim.fahimsrpgmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.fahim.fahimsrpgmod.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class StormQuartzOreBlock extends BaseEntityBlock {

    // Required by BaseEntityBlock in 1.21
    public static final MapCodec<StormQuartzOreBlock> CODEC =
            simpleCodec(StormQuartzOreBlock::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public StormQuartzOreBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StormQuartzOreBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(
                type,
                ModBlockEntities.STORM_QUARTZ_ORE_BE.get(),
                StormQuartzOreBlockEntity::tick
        );
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);

        if (level.isClientSide()) return;
        if (!(entity instanceof Player player)) return;
        if (player.isCreative() || player.isSpectator()) return;

        if (level.getBlockEntity(pos) instanceof StormQuartzOreBlockEntity be) {
            be.onPlayerStep((ServerLevel) level, pos, player);
        }
    }
}