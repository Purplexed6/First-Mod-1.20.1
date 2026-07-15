package net.mak.oresrise;

import net.mak.oresrise.combat.ComboManager;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "oresrise", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onGrindstoneUse(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        ItemStack stack = player.getItemInHand(event.getHand());

        if (level.getBlockState(pos).is(Blocks.GRINDSTONE) && player.isCrouching()) {

            if (stack.is(RubySet.ROUGH_RUBY.get())) {
                processGrind(event, level, pos, player, stack, new ItemStack(RubySet.RUBY.get()));
            }
            else if (stack.is(SapphireSet.ROUGH_SAPPHIRE.get())) {
                processGrind(event, level, pos, player, stack, new ItemStack(SapphireSet.SAPPHIRE.get()));
            }
            else if (stack.is(Items.OBSIDIAN)) {
                processGrind(event, level, pos, player, stack, new ItemStack(ObsidianSet.OBSIDIAN_SHARD.get()));
            }
            else if (stack.is(VibraniumSet.ROUGH_VIBRANIUM.get())) {
                processGrind(event, level, pos, player, stack, new ItemStack(VibraniumSet.VIBRANIUM.get()));
            }
            else if (stack.is(SoulSet.SOUL_FRAGMENT.get())) {
                ItemStack output = new ItemStack(SoulSet.SOUL_POWDER.get());
                output.setCount(2);
                processGrind(event, level, pos, player, stack, output);
            }
        }
    }


    // 💀 ARMOR ABILITIES (THIS IS THE FIX YOU WERE MISSING)
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.level().isClientSide) return;

        // 💎 RUBY → REGEN
        if (hasFullSet(player, ModArmorMaterials.RUBY)) {
            player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.REGENERATION,
                    40,
                    1,
                    false,
                    false
            ));

            UUID id = player.getUUID();

            int lastHit = player.getPersistentData().getInt("oresrise_last_hit");

            if (lastHit != 0 && player.tickCount - lastHit > 20) {

                ComboManager.COMBO_MAP.put(id, 0);

                player.getPersistentData().putInt("oresrise_last_hit", 0);

                System.out.println("COMBO RESET (miss)");
            }
        }

        // 💀 SOUL → SOUL SPEED STYLE
        if (hasFullSet(player, ModArmorMaterials.SOULFORGED)) {
            if (player.getBlockStateOn().is(net.minecraft.tags.BlockTags.SOUL_SPEED_BLOCKS)) {
                player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                        net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED,
                        40,
                        1,
                        false,
                        false
                ));
            }
        }



        // 🖤 ONYX → Void Pressure (passive aura pulse)
        if (hasFullSet(player, ModArmorMaterials.ONYX)) {

            if (player.tickCount % 40 == 0) { // every 2 seconds

                for (var entity : player.level().getEntities(player, player.getBoundingBox().inflate(3))) {

                    if (entity instanceof LivingEntity target && target != player) {

                        target.addEffect(new MobEffectInstance(
                                MobEffects.WEAKNESS,
                                60,
                                0,
                                false,
                                false
                        ));

                        target.addEffect(new MobEffectInstance(
                                MobEffects.MOVEMENT_SLOWDOWN,
                                60,
                                0,
                                false,
                                false
                        ));

                        if (!player.level().isClientSide) {
                            ((ServerLevel) player.level()).sendParticles(
                                    ParticleTypes.SMOKE,
                                    target.getX(),
                                    target.getY() + 1,
                                    target.getZ(),
                                    10,
                                    0.3, 0.5, 0.3,
                                    0.02
                            );
                        }
                    }
                }
            }
        }
    }

    private static boolean hasFullSet(Player player, ArmorMaterial material) {

        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        if (boots.isEmpty() || leggings.isEmpty() || chestplate.isEmpty() || helmet.isEmpty()) {
            return false;
        }

        return ((ArmorItem) helmet.getItem()).getMaterial() == material
                && ((ArmorItem) chestplate.getItem()).getMaterial() == material
                && ((ArmorItem) leggings.getItem()).getMaterial() == material
                && ((ArmorItem) boots.getItem()).getMaterial() == material;
    }

    private static void processGrind(PlayerInteractEvent.RightClickBlock event, Level level, BlockPos pos, Player player, ItemStack stack, ItemStack result) {
        event.setCanceled(true);
        if (!level.isClientSide) {
            stack.shrink(1);
            player.addItem(result);
            level.playSound(null, pos, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }
}