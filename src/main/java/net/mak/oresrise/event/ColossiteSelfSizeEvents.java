package net.mak.oresrise.event;

import net.mak.oresrise.network.ColossiteSizePacket;
import net.mak.oresrise.network.ModNetwork;
import net.mak.oresrise.item.custom.ColossiteSet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = "oresrise")
public class ColossiteSelfSizeEvents {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent event) {

        if (event.getHand() != InteractionHand.MAIN_HAND) {
            return;
        }

        Player player = event.getEntity();

        // Must be sneaking
        if (!player.isShiftKeyDown()) {
            return;
        }

        // Full Colossite armor required
        boolean fullArmor =
                player.getItemBySlot(EquipmentSlot.HEAD)
                        .is(ColossiteSet.COLOSSITE_HELMET.get())
                        && player.getItemBySlot(EquipmentSlot.CHEST)
                        .is(ColossiteSet.COLOSSITE_CHESTPLATE.get())
                        && player.getItemBySlot(EquipmentSlot.LEGS)
                        .is(ColossiteSet.COLOSSITE_LEGGINGS.get())
                        && player.getItemBySlot(EquipmentSlot.FEET)
                        .is(ColossiteSet.COLOSSITE_BOOTS.get());

        if (!fullArmor) {
            return;
        }

        // Server only
        if (!player.level().isClientSide) {

            int size = ColossiteSizeEvents.getSize(player);

            // 0 = normal
            // 1 = small
            // 3 = big
            size++;

            if (size > 3) {
                size = 0;
            }

            ColossiteSizeEvents.setSize(player, size);

            // Sync to clients
            ModNetwork.CHANNEL.send(
                    PacketDistributor.ALL.noArg(),
                    new ColossiteSizePacket(
                            player.getId(),
                            size
                    )
            );

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
                            "Colossite: YOUR SIZE → " + sizeName
                    ),
                    true
            );
        }
    }
}