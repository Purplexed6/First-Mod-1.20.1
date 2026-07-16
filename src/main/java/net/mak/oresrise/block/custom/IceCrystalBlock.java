package net.mak.oresrise.block.custom;

import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class IceCrystalBlock extends BushBlock {

    public IceCrystalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return state.is(Blocks.ICE)
                || state.is(Blocks.PACKED_ICE);
    }
}