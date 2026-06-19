package net.fahim.fahimsrpgmod.block.custom;

import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CauliflowerCropBlock extends CropBlock {

    public static final IntegerProperty AGE =
            IntegerProperty.create("age", 0, 6);

    public CauliflowerCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CAULIFLOWER_SEEDS.get();
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block,
            net.minecraft.world.level.block.state.BlockState> builder) {
        builder.add(AGE);
    }
}