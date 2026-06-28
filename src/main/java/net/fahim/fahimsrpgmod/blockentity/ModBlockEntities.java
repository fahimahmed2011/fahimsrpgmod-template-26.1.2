package net.fahim.fahimsrpgmod.blockentity;

import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.block.custom.StormQuartzOreBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FahimsRPGMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StormQuartzOreBlockEntity>>
            STORM_QUARTZ_ORE_BE = BLOCK_ENTITY_TYPES.register(
            "storm_quartz_ore_be",
            () -> new BlockEntityType<>(
                    StormQuartzOreBlockEntity::new,
                    ModBlocks.STORM_QUARTZ_ORE.get()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);  // ← was wrongly "subscribe"
    }
}