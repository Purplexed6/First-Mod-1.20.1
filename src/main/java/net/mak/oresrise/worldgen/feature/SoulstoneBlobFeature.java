/*package net.mak.oresrise.worldgen.feature;

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

public class SoulstoneBlobFeature extends Feature<NoneFeatureConfiguration> {

    public SoulstoneBlobFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(
            FeaturePlaceContext<NoneFeatureConfiguration> context
    ) {

        LevelAccessor level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        BlockState soulstone =
                ModBlocks.SOULSTONE_BLOCK.get().defaultBlockState();

        BlockPos.MutableBlockPos pos =
                new BlockPos.MutableBlockPos();


        int radiusX = 25 + random.nextInt(21);
        int radiusY = 12 + random.nextInt(14);
        int radiusZ = 25 + random.nextInt(21);

        int placed = 0;

        for (int x = -radiusX; x <= radiusX; x++) {
            for (int y = -radiusY; y <= radiusY; y++) {
                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double normalizedDistance =
                            (double) (x * x) / (radiusX * radiusX)
                                    + (double) (y * y) / (radiusY * radiusY)
                                    + (double) (z * z) / (radiusZ * radiusZ);


                    if (normalizedDistance > 1.0D + random.nextDouble() * 1.1D) {
                        continue;
                    }


                    if (random.nextFloat() < 0.41F) {
                        continue;
                    }

                    pos.set(
                            origin.getX() + x,
                            origin.getY() + y,
                            origin.getZ() + z
                    );


                    if (level.getBlockState(pos).is(Blocks.NETHERRACK)) {

                        level.setBlock(
                                pos,
                                soulstone,
                                2
                        );

                        placed++;
                    }
                }
            }
        }

        return placed > 0;
    }
}*/
