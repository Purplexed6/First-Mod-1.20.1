package net.mak.oresrise.event.armor;

import net.mak.oresrise.ExampleMod;
import net.mak.oresrise.item.ModArmorMaterials;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class OnyxArmorEffects {

    private static final UUID ONYX_SPEED_UUID =
            UUID.fromString("7f5b6b6e-3c9e-4c8f-9b8c-123456789abc");


    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {

        Player player = event.player;

        if (player.level().isClientSide)
            return;


        var attribute = player.getAttribute(Attributes.MOVEMENT_SPEED);

        if (attribute == null)
            return;


        // remove previous modifier
        attribute.removeModifier(ONYX_SPEED_UUID);


        int pieces = 0;


        for (ItemStack armor : player.getArmorSlots()) {

            if (armor.getItem() instanceof ArmorItem armorItem
                    && armorItem.getMaterial() == ModArmorMaterials.ONYX) {

                pieces++;
            }
        }


        if (pieces > 0) {

            double slowdown = -(0.045 * pieces);


            attribute.addTransientModifier(
                    new AttributeModifier(
                            ONYX_SPEED_UUID,
                            "Onyx armor weight",
                            slowdown,
                            AttributeModifier.Operation.MULTIPLY_TOTAL
                    )
            );
        }
    }
}