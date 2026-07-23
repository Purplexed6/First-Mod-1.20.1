package net.mak.oresrise.item.custom;

import net.mak.oresrise.client.ClientShakeHandler;
import net.mak.oresrise.item.ModToolTiers;
import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.network.ShakePacket;
import net.mak.oresrise.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
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

        if (this.getTier() == ModToolTiers.WITHERITE) {

            target.addEffect(new MobEffectInstance(
                    MobEffects.WITHER,
                    100,
                    1,
                    false,
                    false,
                    false
            ));

            if (!target.level().isClientSide) {
                ((ServerLevel) target.level()).sendParticles(
                        ParticleTypes.SMOKE,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        20,
                        0.2, 0.5, 0.2,
                        0.01
                );
            }
        }

        if (this.getTier() == ModToolTiers.SOULFORGED) {

            attacker.heal(0.5f);

            if (!target.level().isClientSide) {
                ((ServerLevel) target.level()).sendParticles(
                        ParticleTypes.SOUL,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        20,
                        0.2, 0.5, 0.2,
                        0.01
                );
            }
        }

        if (this.getTier() == ModToolTiers.HEMOGEM) {

            attacker.heal(1f);

            if (!target.level().isClientSide) {
                ((ServerLevel) target.level()).sendParticles(
                        ParticleTypes.HEART,
                        target.getX(),
                        target.getY() + 1,
                        target.getZ(),
                        5,
                        0.2, 0.5, 0.2,
                        0.1
                );
            }
        }

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

        if (this.getTier() == ModToolTiers.STARRITE) {

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
                    5,
                    false,
                    false,
                    false
            ));
        }

        if (this.getTier() == ModToolTiers.KEYOLITE) {

            target.addEffect(new MobEffectInstance(
                    MobEffects.LEVITATION,
                    20,
                    3,
                    false,
                    false,
                    false
            ));
        }

        if (this.getTier() == ModToolTiers.STAR_PLATINUM && attacker instanceof Player player) {

            var id = player.getUUID();

            int combo = COMBO_MAP.getOrDefault(id, 0) + 1;
            COMBO_MAP.put(id, combo);

            player.getPersistentData().putInt("oresrise_last_hit", player.tickCount);

            System.out.println("COMBO: " + combo);

            if (combo >= 5) {

                System.out.println("IMPACT TRIGGERED");

                if (!attacker.level().isClientSide) {

                    attacker.level().playSound(
                            null,
                            attacker.getX(),
                            attacker.getY(),
                            attacker.getZ(),
                            ModSounds.STAR_PLATINUM_IMPACT.get(),
                            SoundSource.PLAYERS,
                            0.8f,
                            1.0f
                    );

                    ((ServerLevel) target.level()).sendParticles(
                            ParticleTypes.FIREWORK,
                            target.getX(),
                            target.getY() + 1,
                            target.getZ(),
                            60,
                            2.0, 2.0, 2.0,
                            0.2
                    );

                    target.hurt(
                            attacker.damageSources().playerAttack(player),
                            6.0f
                    );

                    target.knockback(2f,
                            attacker.getX() - target.getX(),
                            attacker.getZ() - target.getZ());

                    COMBO_MAP.put(id, 0);
                }

                ModNetwork.CHANNEL.send(
                        PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> attacker),
                        new ShakePacket(4f, 30)
                );
            }
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


