package net.mak.oresrise.mixin;

import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Inject(
            method = "buildSurface",
            at = @At("RETURN")
    )
    private void oresrise$replaceSoulValleyBlocks(
            net.minecraft.server.level.WorldGenRegion level,
            StructureManager structureManager,
            RandomState randomState,
            ChunkAccess chunk,
            CallbackInfo ci
    ) {

        int minX = chunk.getPos().getMinBlockX();
        int minZ = chunk.getPos().getMinBlockZ();

        int minY = chunk.getMinBuildHeight();
        int maxY = chunk.getMaxBuildHeight();

        /*
         * Check the biome once per 4x4 biome column.
         * We don't need a Y dimension here because Soul Sand Valley
         * is effectively the biome of the whole Nether column.
         */
        boolean[][] soulValley = new boolean[4][4];

        for (int bx = 0; bx < 4; bx++) {
            for (int bz = 0; bz < 4; bz++) {

                int x = minX + bx * 4;
                int z = minZ + bz * 4;

                soulValley[bx][bz] = chunk.getNoiseBiome(
                        QuartPos.fromBlock(x),
                        QuartPos.fromBlock(32),
                        QuartPos.fromBlock(z)
                ).is(Biomes.SOUL_SAND_VALLEY);
            }
        }

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        BlockState soulstone =
                ModBlocks.SOULSTONE_BLOCK.get().defaultBlockState();

        BlockState soulGravel =
                ModBlocks.SOUL_GRAVEL.get().defaultBlockState();

        BlockState soulQuartz =
                ModBlocks.SOULSTONE_QUARTZ_ORE.get().defaultBlockState();

        BlockState soulMagma =
                ModBlocks.SOUL_MAGMA.get().defaultBlockState();

        /*
         * Now the vanilla Nether surface rules have already run.
         *
         * This means Soul Sand and Soul Soil already exist and
         * therefore will NOT be accidentally converted.
         */
        for (int x = minX; x < minX + 16; x++) {

            int bx = Math.min(3, (x - minX) >> 2);

            for (int z = minZ; z < minZ + 16; z++) {

                int bz = Math.min(3, (z - minZ) >> 2);

                if (!soulValley[bx][bz]) {
                    continue;
                }

                for (int y = minY; y < maxY; y++) {

                    pos.set(x, y, z);

                    BlockState current = chunk.getBlockState(pos);

                    if (current.is(Blocks.NETHERRACK)) {

                        chunk.setBlockState(
                                pos,
                                soulstone,
                                false
                        );

                    } else if (current.is(Blocks.GRAVEL)) {

                        chunk.setBlockState(
                                pos,
                                soulGravel,
                                false
                        );

                    } else if (current.is(Blocks.NETHER_QUARTZ_ORE)) {

                        chunk.setBlockState(
                                pos,
                                soulQuartz,
                                false
                        );

                    } else if (current.is(Blocks.MAGMA_BLOCK)) {

                        chunk.setBlockState(
                                pos,
                                soulMagma,
                                false
                        );
                    }
                }
            }
        }
    }
}