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

public class RugiteBlobFeature extends Feature<NoneFeatureConfiguration> {

    public RugiteBlobFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        BlockState rugite =
                ModBlocks.RUGITE_BLOCK.get().defaultBlockState();

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos();

        // Blob dimensions
        int radiusX = 3 + random.nextInt(4);
        int radiusY = 2 + random.nextInt(3);
        int radiusZ = 3 + random.nextInt(4);

        int placed = 0;

        // Create an ellipsoid instead of randomly scattering blocks
        for (int x = -radiusX; x <= radiusX; x++) {
            for (int y = -radiusY; y <= radiusY; y++) {
                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double normalizedDistance =
                            (double) (x * x) / (radiusX * radiusX)
                                    + (double) (y * y) / (radiusY * radiusY)
                                    + (double) (z * z) / (radiusZ * radiusZ);

                    // Slight randomness around the edge
                    if (normalizedDistance > 1.0D + random.nextDouble() * 0.25D) {
                        continue;
                    }

                    // Occasionally skip blocks to make the blob less perfect
                    if (random.nextFloat() < 0.08F) {
                        continue;
                    }

                    pos.set(
                            origin.getX() + x,
                            origin.getY() + y,
                            origin.getZ() + z
                    );

                    BlockState current = level.getBlockState(pos);

                    if (current.is(Blocks.DEEPSLATE)
                            || current.is(Blocks.TUFF)) {

                        level.setBlock(
                                pos,
                                rugite,
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