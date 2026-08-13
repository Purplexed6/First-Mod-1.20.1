package net.mak.oresrise.item.custom;

import net.mak.oresrise.event.ColossiteSizeEvents;
import net.mak.oresrise.network.ColossiteSizePacket;
import net.mak.oresrise.network.ModNetwork;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PacketDistributor;

public class ColossiteSwordItem extends SwordItem {

    public ColossiteSwordItem(
            Tier tier,
            int attackDamage,
            float attackSpeed,
            Properties properties
    ) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult interactLivingEntity(
            ItemStack stack,
            Player player,
            LivingEntity target,
            InteractionHand hand
    ) {

        if (!player.level().isClientSide) {

            int size = ColossiteSizeEvents.getSize(target);

            // 0 = normal
            // 1 = small
            // 3 = big
            size++;

            if (size > 3) {
                size = 0;
            }

            // Change size on the server
            ColossiteSizeEvents.setSize(target, size);

            // Sync size to every client
            ModNetwork.CHANNEL.send(
                    PacketDistributor.ALL.noArg(),
                    new ColossiteSizePacket(
                            target.getId(),
                            size
                    )
            );

            // Debug action-bar message
            String sizeName;

            if (size == 0) {
                sizeName = "NORMAL";
            } else if (size == 1) {
                sizeName = "SMALL";
            } else {
                sizeName = "BIG";
            }

            player.displayClientMessage(
                    Component.literal(
                            "Colossite: "
                                    + target.getName().getString()
                                    + " → "
                                    + sizeName
                                    + " (" + size + ")"
                    ),
                    true
            );
        }

        return InteractionResult.sidedSuccess(
                player.level().isClientSide
        );
    }
}