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
    public static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_ORE = registerKey("add_aquamarine_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALEXANDRITE_ORE = registerKey("add_alexandrite_ore");
    public static final ResourceKey<BiomeModifier> ADD_VIBRANIUM_ORE = registerKey("add_vibranium_ore");

    public static final ResourceKey<BiomeModifier> ADD_WITHERITE_ORE = registerKey("add_witherite_ore");
    public static final ResourceKey<BiomeModifier> ADD_SOUL_ORE = registerKey("add_soul_ore");
    public static final ResourceKey<BiomeModifier> ADD_QUINTESSITE_ORE = registerKey("add_quintessite_ore");
    public static final ResourceKey<BiomeModifier> ADD_HEMOGEM_ORE = registerKey("add_hemogem_ore");
    public static final ResourceKey<BiomeModifier> ADD_FLUXITE_ORE = registerKey("add_fluxite_ore");

    public static final ResourceKey<BiomeModifier> ADD_OBLIVIONITE_ORE = registerKey("add_oblivionite_ore");
    public static final ResourceKey<BiomeModifier> ADD_LUNARIS_ORE = registerKey("add_lunaris_ore");
    public static final ResourceKey<BiomeModifier> ADD_CRYPTON_ORE = registerKey("add_crypton_ore");

    public static final ResourceKey<BiomeModifier> ADD_TREE_AMBERWOOD = registerKey("add_tree_amberwood");

    public static final ResourceKey<BiomeModifier> ADD_ICE_CRYSTAL =
            ResourceKey.create(
                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(ExampleMod.MOD_ID, "add_ice_crystal"));

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

        context.register(ADD_AQUAMARINE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModBiomeTags.AQUAMARINE_BIOMES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AQUAMARINE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ALEXANDRITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALEXANDRITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        // context.register(ADD_STARRITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //       biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
        //       HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STARRITE_ORE_PLACED_KEY)),
        //       GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_VIBRANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DEEP_DARK)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.VIBRANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));




        context.register(ADD_WITHERITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WITHERITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SOUL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SOUL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_QUINTESSITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.QUINTESSITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_HEMOGEM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HEMOGEM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_FLUXITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FLUXITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));






        context.register(ADD_OBLIVIONITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.OBLIVIONITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LUNARIS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUNARIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYPTON_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYPTON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));





        context.register(ADD_ICE_CRYSTAL,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModBiomeTags.AQUAMARINE_BIOMES),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ICE_CRYSTAL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));




        context.register(ADD_TREE_AMBERWOOD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AMBERWOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ExampleMod.MOD_ID, name));
    }
}