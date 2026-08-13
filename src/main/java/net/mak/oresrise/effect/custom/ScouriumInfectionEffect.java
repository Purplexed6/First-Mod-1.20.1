package net.mak.oresrise.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ScouriumInfectionEffect extends MobEffect {

    public ScouriumInfectionEffect() {
        super(
                MobEffectCategory.HARMFUL,
                0x5A3A3A
        );

        addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                "7A5D8B3E-2C4F-4D72-9E21-4B8A1F3C6D55",
                -0.25D,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );

        addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                "B3E1F742-9C62-4A85-8D31-5F7C2E9A6B44",
                -0.25D,
                AttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }
}