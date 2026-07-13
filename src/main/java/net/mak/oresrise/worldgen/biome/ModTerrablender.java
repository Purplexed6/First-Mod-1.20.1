package net.mak.oresrise.worldgen.biome;

import net.mak.oresrise.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModNetherRegion(
                new ResourceLocation(ExampleMod.MOD_ID, "nether_region"), 20));
        Regions.register(new ModOverworldRegion(
                new ResourceLocation(ExampleMod.MOD_ID, "overworld_region"), 20));
    }
}