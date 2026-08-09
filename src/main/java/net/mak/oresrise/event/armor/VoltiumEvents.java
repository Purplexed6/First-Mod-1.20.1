package net.mak.oresrise.event.armor;

import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise")
public class VoltiumEvents {


    private static final String SHIELD = "VoltiumShield";


    // SHIFT + RIGHT CLICK AIR = RECHARGE
    @SubscribeEvent
    public static void rechargeShieldAir(PlayerInteractEvent.RightClickEmpty event) {

        rechargeShield(event.getEntity());
    }


    // SHIFT + RIGHT CLICK BLOCK = RECHARGE
    @SubscribeEvent
    public static void rechargeShieldBlock(PlayerInteractEvent.RightClickBlock event) {

        rechargeShield(event.getEntity());
    }



    private static void rechargeShield(Player player) {


        if (player.level().isClientSide)
            return;

        if (!hasFullVoltiumArmor(player))
            return;


        if (!player.isShiftKeyDown())
            return;


        CompoundTag data = player.getPersistentData();


        int shield = data.getInt(SHIELD);

        if (player.experienceLevel > 0 && shield < 3) {

            player.giveExperienceLevels(-1);

            data.putInt(
                    SHIELD,
                    3
            );

            player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal(
                            "Shield Charged!"
                    ).withStyle(ChatFormatting.GOLD),
                    true
            );


            if (player.level() instanceof ServerLevel server) {

                server.sendParticles(
                        ParticleTypes.ELECTRIC_SPARK,
                        player.getX(),
                        player.getY() + 1,
                        player.getZ(),
                        40,
                        0.5,
                        1,
                        0.5,
                        0.1
                );


                player.level().playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.BEACON_ACTIVATE,
                        net.minecraft.sounds.SoundSource.PLAYERS,
                        1.0F,
                        1.2F
                );
            }
        }
    }





    // DAMAGE SHIELD
    @SubscribeEvent
    public static void onPlayerDamage(LivingAttackEvent event) {

        if (!(event.getEntity() instanceof Player player))
            return;


        // Don't consume shield charges from lightning
        if (event.getSource().is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT)) {
            return;
        }


        if (!hasFullVoltiumArmor(player))
            return;


        CompoundTag data = player.getPersistentData();

        int shield = data.getInt(SHIELD);


        if (shield > 0) {

            event.setCanceled(true);

            shield--;

            data.putInt(
                    SHIELD,
                    shield
            );

            player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal(
                            "Voltium Shield: " + shield + "/3"
                    ).withStyle(ChatFormatting.GOLD),
                    true
            );


            if (player.level() instanceof ServerLevel server) {


                server.sendParticles(
                        ParticleTypes.ELECTRIC_SPARK,
                        player.getX(),
                        player.getY() + 1,
                        player.getZ(),
                        15,
                        0.4,
                        0.7,
                        0.4,
                        0.05
                );


                player.playSound(
                        SoundEvents.AMETHYST_BLOCK_CHIME,
                        1.0F,
                        1.5F
                );
            }
        }
    }





    // SLEEP RECHARGE
    @SubscribeEvent
    public static void onSleep(PlayerSleepInBedEvent event) {

        Player player = event.getEntity();

        if (!hasFullVoltiumArmor(player))
            return;

        player.getPersistentData().putInt(
                SHIELD,
                3
        );

        player.displayClientMessage(
                net.minecraft.network.chat.Component.literal(
                        "Shield Charged!"
                ).withStyle(ChatFormatting.GOLD),
                true
        );
    }

    // ⚡ VOLTIUM → Lightning Immunity
    @SubscribeEvent
    public static void onLightningDamage(LivingAttackEvent event) {

        if (!(event.getEntity() instanceof Player player))
            return;


        if (!hasFullVoltiumArmor(player))
            return;


        if (event.getSource().is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT)) {

            event.setCanceled(true);


            player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal(
                            "Lightning Absorbed!"
                    ).withStyle(ChatFormatting.GOLD),
                    true
            );


            if (player.level() instanceof ServerLevel server) {

                server.sendParticles(
                        ParticleTypes.ELECTRIC_SPARK,
                        player.getX(),
                        player.getY() + 1,
                        player.getZ(),
                        20,
                        0.4,
                        0.7,
                        0.4,
                        0.05
                );


                player.playSound(
                        SoundEvents.AMETHYST_BLOCK_CHIME,
                        1.0F,
                        1.8F
                );
            }
        }
    }



    private static boolean hasFullVoltiumArmor(Player player) {


        return player.getInventory().getArmor(0).getItem() instanceof ArmorItem boots
                && boots.getMaterial() == ModArmorMaterials.VOLTIUM

                && player.getInventory().getArmor(1).getItem() instanceof ArmorItem leggings
                && leggings.getMaterial() == ModArmorMaterials.VOLTIUM

                && player.getInventory().getArmor(2).getItem() instanceof ArmorItem chestplate
                && chestplate.getMaterial() == ModArmorMaterials.VOLTIUM

                && player.getInventory().getArmor(3).getItem() instanceof ArmorItem helmet
                && helmet.getMaterial() == ModArmorMaterials.VOLTIUM;
    }
}