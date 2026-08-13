package net.mak.oresrise.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "oresrise")
public class ColossiteSizeEvents {

    private static final String COLOSSITE_SIZE = "ColossiteSize";

    public static int getSize(LivingEntity entity) {
        return entity.getPersistentData().getInt(COLOSSITE_SIZE);
    }

    public static void setSize(LivingEntity entity, int size) {
        entity.getPersistentData().putInt(COLOSSITE_SIZE, size);
        entity.refreshDimensions();
    }

    @SubscribeEvent
    public static void onEntitySize(EntityEvent.Size event) {

        if (!(event.getEntity() instanceof LivingEntity entity)) {
            return;
        }

        int size = getSize(entity);

        if (size == 1) {
            event.setNewSize(
                    event.getNewSize().scale(0.5F)
            );

            event.setNewEyeHeight(
                    event.getNewEyeHeight() * 0.5F
            );

        } else if (size == 3) {
            event.setNewSize(
                    event.getNewSize().scale(3.0F)
            );

            event.setNewEyeHeight(
                    event.getNewEyeHeight() * 3.0F
            );
        }
    }
}