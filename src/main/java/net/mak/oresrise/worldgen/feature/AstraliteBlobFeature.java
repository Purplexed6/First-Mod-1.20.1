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

        // =====================================================
        // FIND A CHORUS PLANT NEARBY
        // =====================================================

        int searchRadius = 8;

        BlockPos chorusBase = null;

        for (int x = -searchRadius; x <= searchRadius && chorusBase == null; x++) {
            for (int y = -8; y <= 8 && chorusBase == null; y++) {
                for (int z = -searchRadius; z <= searchRadius; z++) {

                    BlockPos checkPos = origin.offset(x, y, z);

                    BlockState state = level.getBlockState(checkPos);

                    if (state.is(Blocks.CHORUS_PLANT)
                            || state.is(Blocks.CHORUS_FLOWER)) {

                        // Find the bottom of the chorus plant
                        BlockPos base = checkPos;

                        while (base.getY() > level.getMinBuildHeight()
                                && level.getBlockState(base.below())
                                .is(Blocks.CHORUS_PLANT)) {

                            base = base.below();
                        }

                        chorusBase = base;
                        break;
                    }
                }
            }
        }

        // No chorus plant nearby
        if (chorusBase == null) {
            return false;
        }

        // =====================================================
        // MAKE SURE CHORUS IS ACTUALLY GROWING FROM END STONE
        // =====================================================

        BlockPos ground = chorusBase.below();

        if (!level.getBlockState(ground).is(Blocks.END_STONE)) {
            return false;
        }

        // =====================================================
        // ASTRALITE PATCH SIZE
        // =====================================================

        int radiusX = 3 + random.nextInt(3); // 3-5
        int radiusY = 1 + random.nextInt(2); // 1-2
        int radiusZ = 3 + random.nextInt(3); // 3-5

        int placed = 0;

        // =====================================================
        // CREATE PATCH UNDER CHORUS PLANT
        // =====================================================

        for (int x = -radiusX; x <= radiusX; x++) {
            for (int y = -radiusY; y <= radiusY; y++) {
                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double normalizedDistance =
                            (double) (x * x) / (radiusX * radiusX)
                                    + (double) (y * y) / (radiusY * radiusY)
                                    + (double) (z * z) / (radiusZ * radiusZ);

                    // Irregular edge
                    if (normalizedDistance >
                            1.0D + random.nextDouble() * 0.35D) {
                        continue;
                    }

                    // Small imperfections
                    if (random.nextFloat() < 0.12F) {
                        continue;
                    }

                    pos.set(
                            ground.getX() + x,
                            ground.getY() + y,
                            ground.getZ() + z
                    );

                    BlockState current =
                            level.getBlockState(pos);

                    // Only replace End Stone
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