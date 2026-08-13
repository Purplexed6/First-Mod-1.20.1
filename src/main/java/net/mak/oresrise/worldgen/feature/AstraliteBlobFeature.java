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

public class AstraliteBlobFeature extends Feature<NoneFeatureConfiguration> {

    public AstraliteBlobFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        BlockState astralite =
                ModBlocks.ASTRALITE_BLOCK.get().defaultBlockState();

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos();

        // Smaller End-style blob dimensions
        int radiusX = 4 + random.nextInt(4);
        int radiusY = 4 + random.nextInt(4);
        int radiusZ = 4 + random.nextInt(4);

        int placed = 0;

        // Create an ellipsoid
        for (int x = -radiusX; x <= radiusX; x++) {
            for (int y = -radiusY; y <= radiusY; y++) {
                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double normalizedDistance =
                            (double) (x * x) / (radiusX * radiusX)
                                    + (double) (y * y) / (radiusY * radiusY)
                                    + (double) (z * z) / (radiusZ * radiusZ);

                    // Slight randomness around the edge
                    if (normalizedDistance >
                            1.0D + random.nextDouble() * 0.25D) {
                        continue;
                    }

                    // Make the blob slightly irregular
                    if (random.nextFloat() < 0.08F) {
                        continue;
                    }

                    pos.set(
                            origin.getX() + x,
                            origin.getY() + y + 3,
                            origin.getZ() + z
                    );

                    BlockState current = level.getBlockState(pos);

                    if (current.is(Blocks.END_STONE)) {

                        level.setBlock(
                                pos,
                                astralite,
                                2
                        );

                        placed++;
                    }
                }
            }
        }

        return placed > 0;
    }
}