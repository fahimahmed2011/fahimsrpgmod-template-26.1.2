package net.fahim.fahimsrpgmod.block.custom;

import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CauliflowerCropBlock extends CropBlock {

    public CauliflowerCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    @javax.annotation.Nonnull
    protected ItemLike getBaseSeedId() {
        return () -> ModItems.CAULIFLOWER_SEEDS.get();
    }

    @Override
    public int getMaxAge() {
        return 3;
    }
}