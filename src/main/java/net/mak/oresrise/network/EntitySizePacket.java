package net.mak.oresrise.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EntitySizePacket {

    private final int entityId;
    private final float size;

    public EntitySizePacket(int entityId, float size) {
        this.entityId = entityId;
        this.size = size;
    }

    public EntitySizePacket(FriendlyByteBuf buf) {
        this.entityId = buf.readInt();
        this.size = buf.readFloat();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeFloat(size);
    }

    public static void handle(EntitySizePacket packet, Supplier<NetworkEvent.Context> supplier) {

        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {

            ServerPlayer player = context.getSender();

            if (player == null) {
                return;
            }

            Entity entity = player.level().getEntity(packet.entityId);

            if (entity != null) {
                entity.getPersistentData().putFloat(
                        "colossite_size",
                        packet.size
                );
            }
        });

        context.setPacketHandled(true);
    }
}