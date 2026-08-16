package net.mak.oresrise.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.mak.oresrise.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(NoiseBasedChunkGenerator.class)
public class NoiseBasedChunkGeneratorMixin {

    @Inject(
            method = "buildSurface",
            at = @At("HEAD")
    )
    private void testBuildSurface(
            ChunkAccess chunkAccess,
            WorldGenerationContext context,
            RandomState randomState,
            StructureManager structureManager,
            BiomeManager biomeManager,
            Registry<Biome> registry,
            Blender blender,
            CallbackInfo ci
    ) {
    }
    private void buildSurface(SurfaceSystem instance, RandomState randomState, BiomeManager biomeManager, Registry<Biome> registry, boolean bl, WorldGenerationContext worldGenerationContext, ChunkAccess chunkAccess, NoiseChunk noiseChunk, SurfaceRules.RuleSource ruleSource, Operation<Void> original) {
        SurfaceRules.RuleSource modifiedRules = SurfaceRules.sequence(SurfaceRules.ifTrue(
                SurfaceRules.isBiome(Biomes.SOUL_SAND_VALLEY),
                SurfaceRules.ifTrue(
                        SurfaceRules.not(SurfaceRules.UNDER_CEILING),
                        SurfaceRules.ifTrue(
                                SurfaceRules.not(SurfaceRules.UNDER_FLOOR),
                                SurfaceRules.state(ModBlocks.SOULSTONE_BLOCK.get().defaultBlockState())
                        )
                )
        ), ruleSource);
        original.call(instance, randomState, biomeManager, registry, bl, worldGenerationContext, chunkAccess, noiseChunk, modifiedRules);
    }
}