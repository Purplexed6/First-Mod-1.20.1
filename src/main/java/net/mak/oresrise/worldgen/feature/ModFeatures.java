package net.mak.oresrise.worldgen.feature;

import net.mak.oresrise.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, ExampleMod.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> STARRITE_PILLAR =
            FEATURES.register(
                    "starrite_pillar",
                    () -> new StarritePillarFeature(NoneFeatureConfiguration.CODEC)
            );
}