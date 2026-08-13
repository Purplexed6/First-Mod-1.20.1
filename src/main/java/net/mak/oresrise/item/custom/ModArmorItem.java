package net.mak.oresrise.item.custom;

import com.google.common.collect.ImmutableMap;
import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>()

                    .put(ModArmorMaterials.RUBY, List.of(
                            new MobEffectInstance(MobEffects.REGENERATION, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.SAPPHIRE, List.of(
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.HYDROGEM, List.of(
                            new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.HEMOGEM, List.of(
                            new MobEffectInstance(MobEffects.REGENERATION, 40, 1, false, false)
                    ))

                    .put(ModArmorMaterials.LUNARIS, List.of(
                            new MobEffectInstance(MobEffects.JUMP, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.KEYOLITE, List.of(
                            new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.WITHERITE, List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.DREADSTEEL, List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.VOLTIUM, List.of(
                            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, false, false)
                    ))

                    .put(ModArmorMaterials.ONYX, List.of(
                            new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, false, false)
                    ))

                    .build();


    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
                System.out.println("TICK");
                applySpecialAbilities(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {

        for (Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {

            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> effects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {

                for (MobEffectInstance effect : effects) {
                    addStatusEffectForMaterial(player, effect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, MobEffectInstance effect) {

        player.addEffect(new MobEffectInstance(
                effect.getEffect(),
                40,
                effect.getAmplifier(),
                false,
                false
        ));
    }







    // 💀 SPECIAL “ENCHANT-LIKE” LOGIC
    private void applySpecialAbilities(Player player) {

        if (hasCorrectArmorOn(ModArmorMaterials.LUNARIS, player)) {
            player.fallDistance = 0;
        }

        // 🖤 ONYX → Crushing Aura
        if (hasCorrectArmorOn(ModArmorMaterials.ONYX, player)) {

            if (player.tickCount % 20 == 0) { // every 2 seconds

                for (var entity : player.level().getEntities(player, player.getBoundingBox().inflate(3))) {

                    if (entity instanceof net.minecraft.world.entity.LivingEntity target && target != player) {

                        target.addEffect(new MobEffectInstance(
                                MobEffects.MOVEMENT_SLOWDOWN,
                                60,
                                0,
                                false,
                                false
                        ));

                        target.addEffect(new MobEffectInstance(
                                MobEffects.WEAKNESS,
                                60,
                                0,
                                false,
                                false
                        ));
                    }
                }
            }
        }
    }



    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmor(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmor(1).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmor(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmor(3).getItem();

        return helmet.getMaterial() == material &&
                chestplate.getMaterial() == material &&
                leggings.getMaterial() == material &&
                boots.getMaterial() == material;
    }
}