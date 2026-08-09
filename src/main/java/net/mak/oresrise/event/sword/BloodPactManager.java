package net.mak.oresrise.event.sword;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BloodPactManager {

    private static final Map<UUID, UUID> PACTS = new HashMap<>();

    private BloodPactManager() {
    }

    public static boolean createPact(LivingEntity player, LivingEntity target) {

        if (player == target)
            return false;

        if (isPacted(player) || isPacted(target))
            return false;

        PACTS.put(player.getUUID(), target.getUUID());
        PACTS.put(target.getUUID(), player.getUUID());

        return true;
    }

    public static boolean isPacted(Entity entity) {
        return PACTS.containsKey(entity.getUUID());
    }

    public static boolean isPactedWith(Entity first, Entity second) {

        UUID partner = PACTS.get(first.getUUID());

        return partner != null && partner.equals(second.getUUID());
    }

    public static UUID getPartner(Entity entity) {
        return PACTS.get(entity.getUUID());
    }

    public static void removePact(Entity entity) {

        UUID entityId = entity.getUUID();
        UUID partnerId = PACTS.remove(entityId);

        if (partnerId != null) {
            PACTS.remove(partnerId);
        }
    }

    public static void removePact(UUID uuid) {

        UUID partnerId = PACTS.remove(uuid);

        if (partnerId != null) {
            PACTS.remove(partnerId);
        }
    }
}