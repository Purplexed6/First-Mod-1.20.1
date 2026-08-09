package net.mak.oresrise.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModFoods {
    public static final FoodProperties TOASTED_BREAD = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1), 0.7f).build();

    public static final FoodProperties SAPPHIRE_APPLE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 160), 0.7f).build();

    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f).build();

    public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(3)
            .saturationMod(1.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 260), 0.7f).fast().build();


}