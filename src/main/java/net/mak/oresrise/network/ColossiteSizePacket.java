package net.mak.oresrise.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ColossiteSizePacket {

    private final int entityId;
    private final int size;

    public ColossiteSizePacket(int entityId, int size) {
        this.entityId = entityId;
        this.size = size;
    }

    public ColossiteSizePacket(FriendlyByteBuf buffer) {
        this.entityId = buffer.readInt();
        this.size = buffer.readInt();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeInt(entityId);
        buffer.writeInt(size);
    }

    public static void handle(
            ColossiteSizePacket packet,
            Supplier<NetworkEvent.Context> supplier
    ) {
        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {

            DistExecutor.unsafeRunWhenOn(
                    Dist.CLIENT,
                    () -> () -> {

                        if (Minecraft.getInstance().level == null) {
                            return;
                        }

                        Entity entity =
                                Minecraft.getInstance()
                                        .level
                                        .getEntity(packet.entityId);

                        if (entity != null) {

                            entity.getPersistentData().putInt(
                                    "ColossiteSize",
                                    packet.size
                            );

                            entity.refreshDimensions();
                        }
                    }
            );
        });

        context.setPacketHandled(true);
    }
}