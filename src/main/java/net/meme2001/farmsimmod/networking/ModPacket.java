package net.meme2001.farmsimmod.networking;

import net.meme2001.farmsimmod.Farmsimmod;
import net.meme2001.farmsimmod.networking.packet.DaysC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPacket {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }
    public static void register (){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Farmsimmod.MODID,"messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();
        INSTANCE = net ;

        net.messageBuilder(DaysC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(DaysC2SPacket::new)
                .encoder(DaysC2SPacket::toBytes)
                .consumerMainThread(DaysC2SPacket::handle)
                .add();
    }
    public static <MSG> void SendToSever (MSG message){
        INSTANCE.sendToServer(message);
    }
    public static <MSG> void SendToPlayer (MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    }


