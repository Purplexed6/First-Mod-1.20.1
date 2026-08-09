package net.mak.oresrise.item.custom;

import net.mak.oresrise.event.sword.DreadsteelSwordEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class DreadsteelSwordItem extends SwordItem {

    public DreadsteelSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Item.Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {

        ItemStack stack = player.getItemInHand(hand);

        // Main hand only
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResultHolder.fail(stack);
        }

        // Don't activate while on cooldown
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        if (!level.isClientSide) {

            // Start Dread Nova
            DreadsteelSwordEvents.startDreadNova(player);

            // Damage sword by 1 durability
            stack.hurtAndBreak(
                    1,
                    player,
                    p -> p.broadcastBreakEvent(hand)
            );

            // 10 second cooldown
            player.getCooldowns().addCooldown(
                    this,
                    20 * 10
            );
        }

        return InteractionResultHolder.success(stack);
    }
}