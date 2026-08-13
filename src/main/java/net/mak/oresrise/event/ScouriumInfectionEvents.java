package net.mak.oresrise.event;

import net.mak.oresrise.effect.ModEffects;
import net.mak.oresrise.item.custom.ScouriumSet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = "oresrise")
public class ScouriumInfectionEvents {

    // Infection spread settings
    private static final double SPREAD_RADIUS = 5.0D;
    private static final float SPREAD_CHANCE = 0.10F; // 10%
    private static final int SPREAD_INTERVAL = 40; // 40 ticks = 2 seconds

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {

        LivingEntity entity = event.getEntity();

        // Server side only
        if (entity.level().isClientSide()) {
            return;
        }

        // Full Scourium armor = complete immunity
        if (isWearingFullScouriumSet(entity)) {

            if (entity.hasEffect(ModEffects.SCOURIUM_INFECTION.get())) {
                entity.removeEffect(ModEffects.SCOURIUM_INFECTION.get());
            }

            // Armor wearer is immune, but can still spread the infection
            spreadInfection(entity);

            return;
        }

        // Check if the entity has Scourium Infection
        MobEffectInstance infection =
                entity.getEffect(ModEffects.SCOURIUM_INFECTION.get());

        if (infection == null) {
            return;
        }

        int amplifier = infection.getAmplifier();
        int duration = infection.getDuration();

        // ==========================================
        // DAMAGE
        // ==========================================

        // Higher infection level = faster damage
        int interval = Math.max(1, 40 >> amplifier);

        // Always half a heart of damage
        if (duration % interval == 0) {

            entity.hurt(
                    entity.damageSources().magic(),
                    1.0F
            );
        }

        // ==========================================
        // INFECTION SPREAD
        // ==========================================

        if (duration % SPREAD_INTERVAL == 0) {

            AABB area = entity.getBoundingBox().inflate(SPREAD_RADIUS);

            List<LivingEntity> nearbyEntities =
                    entity.level().getEntitiesOfClass(
                            LivingEntity.class,
                            area
                    );

            for (LivingEntity nearby : nearbyEntities) {

                // Don't infect yourself
                if (nearby == entity) {
                    continue;
                }

                // Don't infect entities that already have Scourium Infection
                if (nearby.hasEffect(ModEffects.SCOURIUM_INFECTION.get())) {
                    continue;
                }

                // 10% chance to spread
                if (entity.getRandom().nextFloat() < SPREAD_CHANCE) {

                    // Spread as Level I
                    nearby.addEffect(new MobEffectInstance(
                            ModEffects.SCOURIUM_INFECTION.get(),
                            20 * 30, // 30 seconds
                            0
                    ));
                }
            }
        }
    }
    private static boolean isWearingFullScouriumSet(LivingEntity entity) {

        ItemStack helmet =
                entity.getItemBySlot(EquipmentSlot.HEAD);

        ItemStack chestplate =
                entity.getItemBySlot(EquipmentSlot.CHEST);

        ItemStack leggings =
                entity.getItemBySlot(EquipmentSlot.LEGS);

        ItemStack boots =
                entity.getItemBySlot(EquipmentSlot.FEET);

        return helmet.is(ScouriumSet.SCOURIUM_HELMET.get())
                && chestplate.is(ScouriumSet.SCOURIUM_CHESTPLATE.get())
                && leggings.is(ScouriumSet.SCOURIUM_LEGGINGS.get())
                && boots.is(ScouriumSet.SCOURIUM_BOOTS.get());
    }

    private static void spreadInfection(LivingEntity entity) {

        if (entity.tickCount % SPREAD_INTERVAL != 0) {
            return;
        }

        AABB area = entity.getBoundingBox().inflate(SPREAD_RADIUS);

        List<LivingEntity> nearbyEntities =
                entity.level().getEntitiesOfClass(
                        LivingEntity.class,
                        area
                );

        for (LivingEntity nearby : nearbyEntities) {

            if (nearby == entity) {
                continue;
            }

            // Full Scourium armor makes them immune
            if (isWearingFullScouriumSet(nearby)) {
                continue;
            }

            if (nearby.hasEffect(
                    ModEffects.SCOURIUM_INFECTION.get())) {
                continue;
            }

            if (entity.getRandom().nextFloat() < SPREAD_CHANCE) {

                nearby.addEffect(new MobEffectInstance(
                        ModEffects.SCOURIUM_INFECTION.get(),
                        20 * 30,
                        0
                ));
            }
        }
    }
}