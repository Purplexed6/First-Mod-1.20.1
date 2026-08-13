package net.mak.oresrise.worldgen;

import net.mak.oresrise.ExampleMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.mak.oresrise.worldgen.ModBiomeTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_SAPPHIRE_ORE = registerKey("add_sapphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registerKey("add_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_HYDRIC_ORE = registerKey("add_hydric_ore");
  //  public static final ResourceKey<BiomeModifier> ADD_JADE_ORE = registerKey("add_jade_ore");
    public static final ResourceKey<BiomeModifier> ADD_SCOUROUS_ORE = registerKey("add_scourous_ore");
    public static final ResourceKey<BiomeModifier> ADD_RAGING_ORE = registerKey("add_platinum_ore");
    public static final ResourceKey<BiomeModifier> ADD_FLUXITE_ORE = registerKey("add_fluxite_ore");

    public static final ResourceKey<BiomeModifier> ADD_SOUL_ORE = registerKey("add_soul_ore");
    //public static final ResourceKey<BiomeModifier> ADD_QUINTESSITE_ORE = registerKey("add_quintessite_ore");
    public static final ResourceKey<BiomeModifier> ADD_SANGUINE_ORE = registerKey("add_sanguine_ore");
    public static final ResourceKey<BiomeModifier> ADD_WAILING_ORE = registerKey("add_wailing_ore");
    public static final ResourceKey<BiomeModifier> ADD_STARDUST_ORE = registerKey("add_stardust_ore");

   // public static final ResourceKey<BiomeModifier> ADD_OBLIVIONITE_ORE = registerKey("add_oblivionite_ore");
    public static final ResourceKey<BiomeModifier> ADD_LUNARIS_ORE = registerKey("add_lunaris_ore");
    public static final ResourceKey<BiomeModifier> ADD_COLOSSAL_ORE = registerKey("add_colossal_ore");
    public static final ResourceKey<BiomeModifier> ADD_ONYX_ORE = registerKey("add_onyx_ore");

    public static final ResourceKey<BiomeModifier> ADD_PHASMITE_PILLAR = registerKey("add_phasmite_pillar");

    public static final ResourceKey<BiomeModifier> ADD_NETHER_BURIED_TREASURE =
            registerKey("add_nether_buried_treasure");

    public static final ResourceKey<BiomeModifier> ADD_RUGITE =
            registerKey("add_rugite");
    public static final ResourceKey<BiomeModifier> ADD_SOULSTONE =
            registerKey("add_soulstone");
    public static final ResourceKey<BiomeModifier> ADD_ASTRALITE =
            registerKey("add_astralite");
    public static final ResourceKey<BiomeModifier> ADD_SOUL_MAGMA =
            registerKey("add_soul_magma");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_SAPPHIRE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SAPPHIRE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RUBY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_FLUXITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FLUXITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_HYDRIC_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.HYDROGEM_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HYDRIC_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        /* context.register(ADD_JADE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.JADE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES)); */

        context.register(ADD_SCOUROUS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SCOUROUS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RAGING_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RAGING_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));





        context.register(ADD_SOUL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SOUL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        /*context.register(ADD_QUINTESSITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.QUINTESSITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));*/

        context.register(ADD_SANGUINE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SANGUINE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WAILING_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WAILING_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STARDUST_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STARDUST_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));






        /* context.register(ADD_OBLIVIONITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OBLIVIONITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES)); */

        context.register(ADD_LUNARIS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUNARIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_COLOSSAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.COLOSSAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ONYX_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ONYX_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(
                ADD_PHASMITE_PILLAR,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.PHASMITE_PILLAR_PLACED_KEY
                                )
                        ),
                        GenerationStep.Decoration.SURFACE_STRUCTURES
                )
        );

        context.register(
                ADD_NETHER_BURIED_TREASURE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_NETHER),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.NETHER_BURIED_TREASURE
                                )
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_RUGITE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.RUGITE_BLOB_PLACED
                                )
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_SOULSTONE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(
                                biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)
                        ),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.SOULSTONE_BLOB_PLACED
                                )
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_ASTRALITE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.ASTRALITE_BLOB_PLACED
                                )
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        context.register(
                ADD_SOUL_MAGMA,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(
                                biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)
                        ),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(
                                        ModPlacedFeatures.SOUL_MAGMA_BLOB_PLACED
                                )
                        ),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ExampleMod.MOD_ID, name));
    }
}