package com.github.inzan17.mixin.chunk.randomTicks;

import com.github.inzan17.UnloadedActivity;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(KelpBlock.class)
public abstract class KelpMixin extends AbstractPlantStemBlock implements FluidFillable {
    protected KelpMixin(Settings settings, Direction growthDirection, VoxelShape outlineShape, boolean tickWater, double growthChance) {
        super(settings, growthDirection, outlineShape, tickWater, growthChance);
    }

    @Override public boolean canSimulateRandTicks(BlockState state, ServerWorld world, BlockPos pos) {
        if (!UnloadedActivity.instance.config.growKelp) return false;
        return super.canSimulateRandTicks(state, world, pos);
    }
}