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
    public static final ResourceKey<PlacedFeature> AQUAMARINE_ORE_PLACED_KEY = registerKey("aquamarine_ore_placed");
    public static final ResourceKey<PlacedFeature> VIBRANIUM_ORE_PLACED_KEY = registerKey("vibranium_ore_placed");

    public static final ResourceKey<PlacedFeature> SOUL_ORE_PLACED_KEY = registerKey("soul_ore_placed");
    public static final ResourceKey<PlacedFeature> QUINTESSITE_ORE_PLACED_KEY = registerKey("quintessite_ore_placed");
    public static final ResourceKey<PlacedFeature> HEMOGEM_ORE_PLACED_KEY = registerKey("hemogem_ore_placed");
    public static final ResourceKey<PlacedFeature> FLUXITE_ORE_PLACED_KEY = registerKey("fluxite_ore_placed");

   // public static final ResourceKey<PlacedFeature> OBLIVIONITE_ORE_PLACED_KEY = registerKey("oblivionite_ore_placed");
    public static final ResourceKey<PlacedFeature> CRYPTON_ORE_PLACED_KEY = registerKey("crypton_ore_placed");
    public static final ResourceKey<PlacedFeature> LUNARIS_ORE_PLACED_KEY = registerKey("lunaris_ore_placed");
    public static final ResourceKey<PlacedFeature> STARRITE_ORE_PLACED_KEY = registerKey("starrite_ore_placed");
    public static final ResourceKey<PlacedFeature> STARRITE_PILLAR_PLACED_KEY = registerKey("starrite_pillar_placed");

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
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(256))));

        /* register(context, JADE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.JADE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16)))); */

        register(context, AQUAMARINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AQUAMARINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16))));
        register(context, VIBRANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIBRANIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(0))));



        register(context, SOUL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(10),
                                VerticalAnchor.absolute(120))));
        register(context, QUINTESSITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUINTESSITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(10),
                                VerticalAnchor.absolute(120))));
        register(context, HEMOGEM_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.HEMOGEM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(10),
                                VerticalAnchor.absolute(120))));



        /* register(context, OBLIVIONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OBLIVIONITE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(36)))); */
        register(context, LUNARIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUNARIS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
        register(context, CRYPTON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYPTON_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));

        register(context,
                STARRITE_PILLAR_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.STARRITE_PILLAR_KEY),
                List.of(
                        CountPlacement.of(5),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(100)
                        ),
                        BiomeFilter.biome()
                ));
    }



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ExampleMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}