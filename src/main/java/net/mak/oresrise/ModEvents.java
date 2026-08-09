package net.mak.oresrise;

import net.mak.oresrise.combat.ComboManager;
import net.mak.oresrise.item.custom.*;
import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
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
                processGrind(event, level, pos, player, stack, new ItemStack(ObsidiumSet.OBSIDIAN_SHARD.get()));
            }
            else if (stack.is(VibraniumSet.ROUGH_VIBRANIUM.get())) {
                processGrind(event, level, pos, player, stack, new ItemStack(VibraniumSet.VIBRANIUM.get()));
            }
            else if (stack.is(Misc.STARDUST_FRAGMENT.get())) {
                processGrind(event, level, pos, player, stack, new ItemStack(Misc.STARDUST.get()));
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

        // 💀 SOULFORGED → Soul Speed + Soul particles
        if (hasFullSet(player, ModArmorMaterials.SOULFORGED)) {

            if (player.getBlockStateOn().is(net.minecraft.tags.BlockTags.SOUL_SPEED_BLOCKS)) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SPEED,
                        40,
                        1,
                        false,
                        false
                ));
            }

            // Cosmetic particles
            if (player.tickCount % 13 == 0) {
                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.SOUL,
                        player.getX(),
                        player.getY() + 1.0,
                        player.getZ(),
                        2,
                        0.35,
                        0.5,
                        0.35,
                        0.01
                );
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

        // 💀 SOULFORGED → Soul particles
        if (hasFullSet(player, ModArmorMaterials.SOULFORGED)) {

            if (player.tickCount % 9 == 0) {

                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.SOUL,
                        player.getX(),
                        player.getY() + 1.0,
                        player.getZ(),
                        1,          // particle count
                        0.35,       // X spread
                        0.5,        // Y spread
                        0.35,       // Z spread
                        0.01        // speed
                );
            }
        }

        if (hasFullSet(player, ModArmorMaterials.HYDROGEM)) {

            if (player.tickCount % 6 == 0) {

                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.BUBBLE,
                        player.getX(),
                        player.getY() + 1.0,
                        player.getZ(),
                        2,          // particle count
                        0.35,       // X spread
                        0.5,        // Y spread
                        0.35,       // Z spread
                        0.01        // speed
                );
            }
        }
    }

    @SubscribeEvent
    public static void onMoltenIronWaterCauldron(PlayerInteractEvent.RightClickBlock event) {

        Level level = event.getLevel();
        Player player = event.getEntity();

        // Server only
        if (level.isClientSide()) {
            return;
        }

        // Get the item in the hand being used
        ItemStack stack = player.getItemInHand(event.getHand());

        // Must be holding Molten Iron
        if (!stack.is(Misc.MOLTEN_IRON_INGOT.get())) {
            return;
        }

        BlockPos pos = event.getPos();

        // Must be a water-filled cauldron
        if (!level.getBlockState(pos).is(Blocks.WATER_CAULDRON)) {
            return;
        }

        // Get current water level (1-3)
        int waterLevel = level.getBlockState(pos)
                .getValue(LayeredCauldronBlock.LEVEL);

        // Remove 1 molten iron
        stack.shrink(1);

        // Give 1 normal iron ingot
        ItemStack iron = new ItemStack(Items.IRON_INGOT);

        if (!player.getInventory().add(iron)) {
            player.drop(iron, false);
        }

        // Remove exactly ONE level of water
        if (waterLevel <= 1) {

            // Cauldron becomes empty
            level.setBlock(
                    pos,
                    Blocks.CAULDRON.defaultBlockState(),
                    3
            );

        } else {

            // Reduce water level by 1
            level.setBlock(
                    pos,
                    Blocks.WATER_CAULDRON.defaultBlockState()
                            .setValue(
                                    LayeredCauldronBlock.LEVEL,
                                    waterLevel - 1
                            ),
                    3
            );
        }

        // Stop normal cauldron interaction
        event.setCanceled(true);
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





    private static final String GIVEN_BOOK = "OresRiseGuideGiven";

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {

        Player player = event.getEntity();

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }


        Advancement advancement =
                serverPlayer.server.getAdvancements()
                        .getAdvancement(
                                new ResourceLocation("oresrise", "oresrise")
                        );


        if (advancement == null) {
            return;
        }


        AdvancementProgress progress =
                serverPlayer.getAdvancements()
                        .getOrStartProgress(advancement);


        // Give the book only once
        if (!progress.isDone()) {


            ItemStack book = GuideBook.createBook();

            player.getInventory().add(book);


            // Complete the root advancement silently
            for (String criterion : progress.getRemainingCriteria()) {

                serverPlayer.getAdvancements()
                        .award(advancement, criterion);

            }
        }
    }
}