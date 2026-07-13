package net.mak.oresrise.worldgen.biome.surface;

import net.mak.oresrise.block.ModBlocks;
import net.mak.oresrise.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import static net.minecraft.world.level.levelgen.SurfaceRules.*;
import static net.minecraft.world.level.levelgen.SurfaceRules.isBiome;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource ASTRALITE = makeStateRule(ModBlocks.ASTRALITE.get());


    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                // --- NETHER BIOME (Pale Depths) ---
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.PALE_DEPTHS),
                        SurfaceRules.state(ModBlocks.PALESLATE.get().defaultBlockState())
                ),

                // --- OVERWORLD BIOME (Astral Plains) ---
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ASTRAL_PLAINS),
                        SurfaceRules.sequence(
                                // FORCE Astralite on the very top, even if there's dirt/grass
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(ModBlocks.ASTRALITE.get().defaultBlockState())),

                                // FORCE Umbrock for everything else (replaces stone/granite/etc)
                                SurfaceRules.state(ModBlocks.UMBROCK.get().defaultBlockState())
                        )
                )

        );
    }


    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}