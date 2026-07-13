package net.mak.oresrise.network;

import net.mak.oresrise.client.ClientShakeHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShakePacket {

    private final float strength;
    private final int duration;

    public ShakePacket(float strength, int duration) {
        this.strength = strength;
        this.duration = duration;
    }

    public ShakePacket(FriendlyByteBuf buf) {
        this.strength = buf.readFloat();
        this.duration = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeFloat(strength);
        buf.writeInt(duration);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            ClientShakeHandler.triggerShake(strength, duration);
        });
        return true;
    }
}