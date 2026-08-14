package net.mak.oresrise.worldgen.feature;

import com.mojang.serialization.Codec;
import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VoidstoneIslandFeature extends Feature<NoneFeatureConfiguration> {

    public VoidstoneIslandFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        BlockState voidstone =
                ModBlocks.VOIDSTONE_BLOCK.get().defaultBlockState();

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos();

        // =====================================================
        // FIND THE TOP OF THE ISLAND
        // =====================================================

        int topY = origin.getY();

        while (topY < level.getMaxBuildHeight()
                && level.getBlockState(
                new BlockPos(origin.getX(), topY + 1, origin.getZ())
        ).is(Blocks.END_STONE)) {

            topY++;
        }

        while (topY > level.getMinBuildHeight()
                && !level.getBlockState(
                new BlockPos(origin.getX(), topY, origin.getZ())
        ).is(Blocks.END_STONE)) {

            topY--;
        }

        // We didn't land on End Stone
        if (!level.getBlockState(
                new BlockPos(origin.getX(), topY, origin.getZ())
        ).is(Blocks.END_STONE)) {
            return false;
        }

        // =====================================================
        // FIND ISLAND SIZE
        // =====================================================

        int searchRadius = 12;

        int minX = origin.getX();
        int maxX = origin.getX();
        int minZ = origin.getZ();
        int maxZ = origin.getZ();

        int endStoneCount = 0;

        for (int x = -searchRadius; x <= searchRadius; x++) {
            for (int z = -searchRadius; z <= searchRadius; z++) {

                BlockPos check =
                        new BlockPos(
                                origin.getX() + x,
                                topY,
                                origin.getZ() + z
                        );

                if (level.getBlockState(check).is(Blocks.END_STONE)) {

                    minX = Math.min(minX, check.getX());
                    maxX = Math.max(maxX, check.getX());

                    minZ = Math.min(minZ, check.getZ());
                    maxZ = Math.max(maxZ, check.getZ());

                    endStoneCount++;
                }
            }
        }

        // =====================================================
        // ONLY SMALL ISLANDS
        // =====================================================

        int width = maxX - minX + 1;
        int depth = maxZ - minZ + 1;

        // Too large = probably a main End island
        if (width > 12 || depth > 12) {
            return false;
        }

        // Too small = probably just noise / invalid placement
        if (width < 3 || depth < 3) {
            return false;
        }

        // =====================================================
        // REPLACE THE ENTIRE ISLAND
        // =====================================================

        int placed = 0;

        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {

                // Start above the island and work downward
                for (int y = topY; y >= level.getMinBuildHeight(); y--) {

                    pos.set(x, y, z);

                    BlockState current =
                            level.getBlockState(pos);

                    if (!current.is(Blocks.END_STONE)) {
                        continue;
                    }

                    level.setBlock(
                            pos,
                            voidstone,
                            2
                    );

                    placed++;
                }
            }
        }

        return placed > 0;
    }
}