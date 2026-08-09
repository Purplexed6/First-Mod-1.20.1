package net.mak.oresrise.item.custom;

import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class VoltiumArmorItem extends ArmorItem {


    public VoltiumArmorItem(
            net.minecraft.world.item.ArmorMaterial material,
            Type type,
            Properties properties
    ) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {

        if (!level.isClientSide && hasFullVoltiumArmor(player)) {

            CompoundTag data = player.getPersistentData();

            // Initialize shield
            if (!data.contains("VoltiumShield")) {
                data.putInt("VoltiumShield", 3);
            }


            // Permanent Speed I
            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED,
                            40,
                            0,
                            false,
                            false
                    )
            );
        }
    }


    private boolean hasFullVoltiumArmor(Player player) {

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