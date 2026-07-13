package net.mak.oresrise.worldgen.biome;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.entity.ModEntities;
import net.mak.oresrise.sound.ModSounds;
import net.mak.oresrise.worldgen.ModPlacedFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> PALE_DEPTHS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(ExampleMod.MOD_ID, "pale_depths"));
    public static final ResourceKey<Biome> ASTRAL_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(ExampleMod.MOD_ID, "astral_plains"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(PALE_DEPTHS, testBiome(context));
        context.register(ASTRAL_PLAINS, testBiome2(context));
    }
    public static Biome testBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.EMBER_HUSK.get(), 2, 3, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // 1. Add the vanilla Basalt Pillar feature
        // 1. Add the vanilla Basalt Pillar feature
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, // Changed from SURFACE_STRUCTURES
                NetherPlacements.BASALT_PILLAR);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, // Changed from SURFACE_STRUCTURES
                NetherPlacements.BASALT_BLOBS);

        // 3. If you made custom Witherite Ore for this biome, add it here:
         biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.WITHERITE_ORE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(2.0f)
                .downfall(0.0f)
                // Use this to help shape the terrain if you have a custom Noise Generator
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x000000)
                        .fogColor(0x202026)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.SOUND_BLOCK_STEP.getHolder().get())).build())
                .build();
    }






    public static Biome testBiome2(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 2, 3, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // 3. If you made custom Witherite Ore for this biome, add it here:
        //biomeBuilder.addFeature(
        //        GenerationStep.Decoration.UNDERGROUND_ORES,
        //        ModPlacedFeatures.STARRITE_ORE_PLACED_KEY);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION,
                ModPlacedFeatures.ASTRALITE_SURFACE_PLACED_KEY
        );
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.UMBROCK_FILLER_PLACED_KEY);

        // Adds large Amethyst geodes inside your Umbrock walls
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, CavePlacements.AMETHYST_GEODE);

// Adds "Lakes" of something weird, like Glowing Liquid (if you have a custom fluid)
// Or just add Glowstone patches to the ceiling/walls
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.5f)
                .downfall(0.0f)
                // Use this to help shape the terrain if you have a custom Noise Generator
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.05f)) // Stardust!
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .skyColor(0x050505) // Black sky
                        .fogColor(0x1a012e) // Dark purple fog
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.SOUND_BLOCK_STEP.getHolder().get())).build())
                .build();
    }
}