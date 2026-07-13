package net.mak.oresrise.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModFoods {
    public static final FoodProperties TOASTED_BREAD = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1), 0.7f).build();
    public static final FoodProperties BREAD_SLICE = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 150, 0), 0.5f).build();

    public static final FoodProperties SAPPHIRE_APPLE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 160), 0.7f).build();
    public static final FoodProperties OBSIDIAN_COOKIE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1), 0.7f).build();
    public static final FoodProperties SOUL_COOKIE = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160), 0.7f).fast().build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f).build();
    public static final FoodProperties CHEESE_SLICE = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.1f).build();

    public static final FoodProperties CHEESE_TOMATO_SANDWICH = new FoodProperties.Builder().nutrition(9)
            .saturationMod(1.5f).build();
    public static final FoodProperties GRILLED_CHEESE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(1.9f).build();
    public static final FoodProperties CHEESE_SANDWICH = new FoodProperties.Builder().nutrition(6)
            .saturationMod(1.2f).build();

    public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(3)
            .saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 260), 0.7f).fast().build();

    public static final FoodProperties FLAMING_PORKCHOP = new FoodProperties.Builder().nutrition(9)
            .saturationMod(1.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.7f).build();
    public static final FoodProperties FLAMING_STEAK = new FoodProperties.Builder().nutrition(9)
            .saturationMod(1.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.7f).build();
    public static final FoodProperties FLAMING_RABBIT = new FoodProperties.Builder().nutrition(6)
            .saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.7f).build();
    public static final FoodProperties FLAMING_CHICKEN = new FoodProperties.Builder().nutrition(7)
            .saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.7f).build();
    public static final FoodProperties FLAMING_MUTTON = new FoodProperties.Builder().nutrition(7)
            .saturationMod(1.6f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 0.7f).build();
}