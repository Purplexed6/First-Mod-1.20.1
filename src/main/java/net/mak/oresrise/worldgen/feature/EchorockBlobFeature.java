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

public class EchorockBlobFeature extends Feature<NoneFeatureConfiguration> {

    public EchorockBlobFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        BlockState echorock =
                ModBlocks.ECHOROCK_BLOCK.get().defaultBlockState();

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos();

        // =====================================================
        // FIND THE SURFACE
        // =====================================================

        int groundY = level.getMaxBuildHeight() - 1;

        while (groundY > level.getMinBuildHeight()
                && !level.getBlockState(
                new BlockPos(origin.getX(), groundY, origin.getZ())
        ).is(Blocks.END_STONE)) {

            groundY--;
        }

        if (!level.getBlockState(
                new BlockPos(origin.getX(), groundY, origin.getZ())
        ).is(Blocks.END_STONE)) {
            return false;
        }

        // Only generate on the main End island
        if (groundY < 45) {
            return false;
        }

        // =====================================================
        // BOULDER SIZE
        // =====================================================

        int radiusX = 3 + random.nextInt(2);
        int radiusY = 2 + random.nextInt(2);
        int radiusZ = 3 + random.nextInt(2);

        // Bury the bottom of the boulder
        int centerY = groundY + radiusY - 1;

        int placed = 0;

        // =====================================================
        // CREATE ROUND BOULDER
        // =====================================================

        for (int x = -radiusX; x <= radiusX; x++) {
            for (int y = -radiusY; y <= radiusY; y++) {
                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double nx = (double) x / radiusX;
                    double ny = (double) y / radiusY;
                    double nz = (double) z / radiusZ;

                    double distance =
                            nx * nx +
                                    ny * ny +
                                    nz * nz;

                    // Outside the boulder
                    if (distance > 1.0D) {
                        continue;
                    }

                    // Slightly irregular edges
                    if (distance > 0.70D
                            && random.nextFloat() < 0.05F) {
                        continue;
                    }

                    pos.set(
                            origin.getX() + x,
                            centerY + y,
                            origin.getZ() + z
                    );

                    BlockState current =
                            level.getBlockState(pos);

                    // Only replace End Stone or air
                    if (!current.is(Blocks.END_STONE)
                            && !current.isAir()) {
                        continue;
                    }

                    // =================================================
                    // REMOVE ISOLATED OUTER BLOCKS
                    // =================================================

                    if (distance > 0.80D) {

                        int neighbors = 0;

                        // +X
                        double nx1 = (double) (x + 1) / radiusX;
                        double ny1 = (double) y / radiusY;
                        double nz1 = (double) z / radiusZ;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // -X
                        nx1 = (double) (x - 1) / radiusX;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // +Y
                        nx1 = (double) x / radiusX;
                        ny1 = (double) (y + 1) / radiusY;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // -Y
                        ny1 = (double) (y - 1) / radiusY;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // +Z
                        ny1 = (double) y / radiusY;
                        nz1 = (double) (z + 1) / radiusZ;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // -Z
                        nz1 = (double) (z - 1) / radiusZ;

                        if (nx1 * nx1 + ny1 * ny1 + nz1 * nz1 <= 1.0D) {
                            neighbors++;
                        }

                        // Remove lonely blocks
                        if (neighbors < 2) {
                            continue;
                        }
                    }

                    level.setBlock(
                            pos,
                            echorock,
                            2
                    );

                    placed++;
                }
            }
        }

        return placed > 0;
    }
}