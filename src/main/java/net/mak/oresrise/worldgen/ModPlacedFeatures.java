package net.mak.oresrise.worldgen;

import net.mak.oresrise.ExampleMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
  //  public static final ResourceKey<PlacedFeature> JADE_ORE_PLACED_KEY = registerKey("jade_ore_placed");
    public static final ResourceKey<PlacedFeature> HYDRIC_ORE_PLACED_KEY = registerKey("hydric_ore_placed");
    public static final ResourceKey<PlacedFeature> SCOUROUS_ORE_PLACED_KEY = registerKey("scourous_ore_placed");
    public static final ResourceKey<PlacedFeature> RAGING_ORE_PLACED_KEY = registerKey("platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> FLUXITE_ORE_PLACED_KEY = registerKey("fluxite_ore_placed");

    public static final ResourceKey<PlacedFeature> SOUL_ORE_PLACED_KEY = registerKey("soul_ore_placed");
  //  public static final ResourceKey<PlacedFeature> QUINTESSITE_ORE_PLACED_KEY = registerKey("quintessite_ore_placed");
    public static final ResourceKey<PlacedFeature> SANGUINE_ORE_PLACED_KEY = registerKey("sanguine_ore_placed");
    public static final ResourceKey<PlacedFeature> WAILING_ORE_PLACED_KEY = registerKey("wailing_ore_placed");
    public static final ResourceKey<PlacedFeature> STARDUST_ORE_PLACED_KEY = registerKey("stardust_ore_placed");

   // public static final ResourceKey<PlacedFeature> OBLIVIONITE_ORE_PLACED_KEY = registerKey("oblivionite_ore_placed");
    public static final ResourceKey<PlacedFeature> COLOSSAL_ORE_PLACED_KEY = registerKey("colossal_ore_placed");
    public static final ResourceKey<PlacedFeature> ONYX_ORE_PLACED_KEY = registerKey("onyx_ore_placed");
    public static final ResourceKey<PlacedFeature> LUNARIS_ORE_PLACED_KEY = registerKey("lunaris_ore_placed");

    public static final ResourceKey<PlacedFeature> PHASMIC_ORE_PLACED_KEY = registerKey("phasmic_ore_placed");
    public static final ResourceKey<PlacedFeature> PHASMITE_PILLAR_PLACED_KEY = registerKey("phasmite_pillar_placed");

    public static final ResourceKey<PlacedFeature> RUGITE_BLOB_PLACED =
            registerKey("rugite_blob_placed");
    //public static final ResourceKey<PlacedFeature> SOULSTONE_BLOB_PLACED =
      //      registerKey("soulstone_blob_placed");
    public static final ResourceKey<PlacedFeature> ASTRALITE_BLOB_PLACED =
            registerKey("astralite_blob_placed");
    public static final ResourceKey<PlacedFeature> ECHOROCK_BLOB_PLACED =
            registerKey("echorock_blob_placed");
    public static final ResourceKey<PlacedFeature> VOIDSTONE_BLOB_PLACED =
            registerKey("voidstone_blob_placed");
    //public static final ResourceKey<PlacedFeature> SOUL_MAGMA_BLOB_PLACED =
      //      registerKey("soul_magma_blob_placed");

    public static final ResourceKey<PlacedFeature> NETHER_BURIED_TREASURE =
            registerKey("nether_buried_treasure");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16))));

        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16))));

        register(context, FLUXITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLUXITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(100,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(256))));

        /* register(context, JADE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.JADE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16)))); */

        register(context, HYDRIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HYDRIC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(256))));

        register(context, SCOUROUS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCOUROUS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(75,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(0))));

        register(context, RAGING_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RAGING_ORE_KEY),
                ModOrePlacement.commonOrePlacement(75,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(256))));



        register(context, SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(5),
                                VerticalAnchor.absolute(120))));
        /*register(context, QUINTESSITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUINTESSITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(5),
                                VerticalAnchor.absolute(120))));*/
        register(context, SANGUINE_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SANGUINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(5),
                                VerticalAnchor.absolute(120))));

        register(context, WAILING_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.WAILING_ORE_KEY),
                ModOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(50),
                                VerticalAnchor.absolute(120))));

        register(context, STARDUST_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.STARDUST_ORE_KEY),
                ModOrePlacement.commonOrePlacement(75,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(5),
                                VerticalAnchor.absolute(80))));



        /* register(context, OBLIVIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OBLIVIONITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(36)))); */
        register(context, LUNARIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        register(context, COLOSSAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COLOSSAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(60,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));
        register(context, ONYX_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COLOSSAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));


        register(
                context,
                NETHER_BURIED_TREASURE,
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.NETHER_BURIED_TREASURE
                ),
                List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(20),
                                VerticalAnchor.absolute(90)
                        ),
                        BiomeFilter.biome()
                )
        );

        register(context,
                PHASMITE_PILLAR_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PHASMITE_PILLAR_KEY),
                List.of(
                        CountPlacement.of(3),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(100)
                        ),
                        BiomeFilter.biome()
                ));

        Holder<ConfiguredFeature<?, ?>> rugiteBlob =
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.RUGITE_BLOB
                );

        /*Holder<ConfiguredFeature<?, ?>> soulstoneBlob =
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.SOULSTONE_BLOB
                );*/

        Holder<ConfiguredFeature<?, ?>> astraliteBlob =
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.ASTRALITE_BLOB
                );

        Holder<ConfiguredFeature<?, ?>> voidstoneBlob =
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.VOIDSTONE_BLOB
                );

        Holder<ConfiguredFeature<?, ?>> echorockBlob =
                configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.ECHOROCK_BLOB
                );

        //Holder<ConfiguredFeature<?, ?>> soulmagmaBlob =
          //      configuredFeatures.getOrThrow(
            //            ModConfiguredFeatures.SOUL_MAGMA_BLOB);

        register(
                context,
                RUGITE_BLOB_PLACED,
                rugiteBlob,
                List.of(
                        CountPlacement.of(2),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(0)
                        ),
                        BiomeFilter.biome()
                )
        );

        /*register(
                context,
                SOULSTONE_BLOB_PLACED,
                soulstoneBlob,
                List.of(
                        CountPlacement.of(64),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                )
        );*/

        register(
                context,
                ASTRALITE_BLOB_PLACED,
                astraliteBlob,
                List.of(
                        CountPlacement.of(5),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                ECHOROCK_BLOB_PLACED,
                echorockBlob,
                List.of(
                        RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                )
        );

        register(
                context,
                VOIDSTONE_BLOB_PLACED,
                voidstoneBlob,
                List.of(
                        CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                )
        );

        /*register(
                context,
                SOUL_MAGMA_BLOB_PLACED,
                soulmagmaBlob,
                List.of(
                        CountPlacement.of(64),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(128)
                        ),
                        BiomeFilter.biome()
                )
        );*/
    }



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}