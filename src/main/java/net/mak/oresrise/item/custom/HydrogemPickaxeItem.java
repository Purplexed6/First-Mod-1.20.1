package net.mak.oresrise.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class HydrogemPickaxeItem extends PickaxeItem {

    private static final String CHARGE_TAG = "HydrogemCharge";

    public HydrogemPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }


    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {

        if (!level.isClientSide && entity instanceof Player player) {

            CompoundTag tag = stack.getOrCreateTag();

            int charge = tag.getInt(CHARGE_TAG);

            charge++;


            if (charge >= 20) {

                player.addEffect(new MobEffectInstance(
                        MobEffects.WATER_BREATHING, // Haste
                        300, // 10 seconds
                        0, // Haste IV
                        false,
                        false,
                        true
                ));

                charge = 0;
            }


            tag.putInt(CHARGE_TAG, charge);
        }


        return super.mineBlock(stack, level, state, pos, entity);
    }


    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {

        CompoundTag tag = stack.getTag();

        int charge = 0;

        if (tag != null) {
            charge = tag.getInt(CHARGE_TAG);
        }


        tooltip.add(
                Component.literal("Charge: " + charge + "/20 blocks")
                        .withStyle(ChatFormatting.DARK_BLUE)
        );


        super.appendHoverText(stack, level, tooltip, flag);
    }
}
