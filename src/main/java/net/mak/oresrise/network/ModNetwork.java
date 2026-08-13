package net.mak.oresrise.network;

import net.mak.oresrise.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetwork {

    private static final String PROTOCOL = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ExampleMod.MOD_ID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    private static int packetId = 0;

    public static int id() {
        return packetId++;
    }

    public static void register() {

        CHANNEL.registerMessage(
                id(),
                ShakePacket.class,
                ShakePacket::toBytes,
                ShakePacket::new,
                ShakePacket::handle
        );

        CHANNEL.registerMessage(
                id(),
                EntitySizePacket.class,
                EntitySizePacket::toBytes,
                EntitySizePacket::new,
                EntitySizePacket::handle
        );

        CHANNEL.registerMessage(
                id(),
                ColossiteSizePacket.class,
                ColossiteSizePacket::toBytes,
                ColossiteSizePacket::new,
                ColossiteSizePacket::handle
        );
    }
}