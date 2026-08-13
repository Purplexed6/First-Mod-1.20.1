package net.mak.oresrise.item.custom;

import net.mak.oresrise.client.ClientShakeHandler;
import net.mak.oresrise.effect.ModEffects;
import net.mak.oresrise.item.ModToolTiers;
import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.mak.oresrise.sound.ModSounds;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModSwordItem extends SwordItem {

    private static final Map<UUID, Integer> COMBO_MAP = new HashMap<>(); // ⭐ for Star Platinum

    public ModSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (this.getTier() == ModToolTiers.DREADSTEEL) {

            attacker.heal(1f);

            target.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,
                    100,
                    0,
                    false,
                    false,
                    false
            ));

            target.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    100,
                    0,
                    false,
                    false,
                    false
            ));

            if (!target.level().isClientSide) {
                ((ServerLevel) target.level()).sendParticles(
                        ParticleTypes.SOUL,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        5,
                        0.2, 0.5, 0.2,
                        0.01
                );
            }
        }

        if (this.getTier() == ModToolTiers.PHASMITE) {

            if (attacker.getRandom().nextFloat() < 0.2f) {

                target.hurt(
                        target.damageSources().magic(),
                        2.0f
                );

                if (!target.level().isClientSide) {

                    ((ServerLevel) target.level()).sendParticles(
                            ParticleTypes.FIREWORK,
                            target.getX(),
                            target.getY() + 1,
                            target.getZ(),
                            30,
                            1.0, 1.0, 1.0,
                            0.1
                    );
                }

                if (!attacker.level().isClientSide) {

                    attacker.level().playSound(
                            null,
                            attacker.getX(),
                            attacker.getY(),
                            attacker.getZ(),
                            ModSounds.GLOW.get(),
                            SoundSource.PLAYERS,
                            0.8f,
                            1.0f
                    );
                    attacker.level().playSound(
                            null,
                            attacker.getX(),
                            attacker.getY(),
                            attacker.getZ(),
                            ModSounds.DING.get(),
                            SoundSource.PLAYERS,
                            0.8f,
                            1.0f
                    );
                }
            }

            target.addEffect(new MobEffectInstance(
                    MobEffects.GLOWING,
                    100,
                    0,
                    false,
                    false,
                    false
            ));
        }

        if (this.getTier() == ModToolTiers.LUNARIS) {

            target.addEffect(new MobEffectInstance(
                    MobEffects.GLOWING,
                    100,
                    0,
                    false,
                    false,
                    false
            ));
            target.addEffect(new MobEffectInstance(
                    MobEffects.LEVITATION,
                    20,
                    9,
                    false,
                    false,
                    false
            ));
        }

        if (this.getTier() == ModToolTiers.KEYOLITE) {

            target.addEffect(new MobEffectInstance(
                    MobEffects.LEVITATION,
                    15,
                    3,
                    false,
                    false,
                    false
            ));
        }

        if (this.getTier() == ModToolTiers.SCOURIUM) {

            target.addEffect(new MobEffectInstance(
                    ModEffects.SCOURIUM_INFECTION.get(),
                    60,
                    1,
                    false,
                    true,
                    true
            ));
        }

        float charged = attacker.getPersistentData().getFloat("charged_hit");

        if (charged > 0) {

            target.hurt(
                    attacker.damageSources().playerAttack((Player) attacker),
                    4.0f * charged
            );

            attacker.getPersistentData().putFloat("charged_hit", 0);

            System.out.println("CHARGED HIT!");
        }







        return super.hurtEnemy(stack, target, attacker);
    }
}


