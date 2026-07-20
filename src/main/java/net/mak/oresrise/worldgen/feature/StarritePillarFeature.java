package net.mak.oresrise.worldgen.feature;

import com.mojang.serialization.Codec;
import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class StarritePillarFeature extends Feature<NoneFeatureConfiguration> {

    public StarritePillarFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        LevelAccessor level = context.level();
        BlockPos origin = context.origin();

        RandomSource random = context.random();

        for (int x = -8; x <= 8; x++) {
            for (int y = 0; y <= 150; y++) {
                for (int z = -8; z <= 8; z++) {

                    BlockPos pos = origin.offset(x, y, z);

                    if (level.getBlockState(pos).is(Blocks.OBSIDIAN)
                            && random.nextFloat() < 0.01F) {

                        level.setBlock(
                                pos,
                                ModBlocks.STARRITE_ORE.get().defaultBlockState(),
                                2
                        );
                    }
                }
            }
        }

        return true;
    }
}
