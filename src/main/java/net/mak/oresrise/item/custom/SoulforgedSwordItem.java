package net.mak.oresrise.item.custom;

import net.mak.oresrise.event.sword.SoulTornadoManager;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class SoulforgedSwordItem extends SwordItem {

    public SoulforgedSwordItem(
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

        // Must be main hand
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResultHolder.fail(stack);
        }

        // Cooldown
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        if (!level.isClientSide) {

            // Start Tornado of Souls
            SoulTornadoManager.startTornado(player);

            // Damage sword by 1 durability
            stack.hurtAndBreak(
                    1,
                    player,
                    p -> p.broadcastBreakEvent(hand)
            );

            // Trigger advancement
            triggerAdvancement(player);

            // 10 second cooldown
            player.getCooldowns().addCooldown(
                    this,
                    150
            );
        }

        return InteractionResultHolder.success(stack);
    }


    private void triggerAdvancement(Player player) {

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        Advancement advancement =
                serverPlayer.server
                        .getAdvancements()
                        .getAdvancement(
                                new ResourceLocation(
                                        "oresrise",
                                        "tornado_of_souls"
                                )
                        );

        if (advancement == null) {
            return;
        }

        serverPlayer.getAdvancements().award(
                advancement,
                "tornado_of_souls"
        );
    }
}