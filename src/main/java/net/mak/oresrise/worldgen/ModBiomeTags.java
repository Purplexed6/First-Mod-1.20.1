package net.mak.oresrise.worldgen;

import net.mak.oresrise.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> HYDROGEM_BIOMES =
            TagKey.create(
                    Registries.BIOME,
                    new ResourceLocation(ExampleMod.MOD_ID, "aquamarine_biomes")
            );
}