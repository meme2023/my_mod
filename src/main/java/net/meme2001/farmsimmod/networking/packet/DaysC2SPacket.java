package net.meme2001.farmsimmod.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DaysC2SPacket {
    private static final String MESSAGE_IS_Rotten = "message.farmsimmod.isRotten";


    public DaysC2SPacket() {

    }

    public DaysC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = context.getSender().getLevel();
            if (level.getDayTime() == 24000) {
                player.sendSystemMessage(Component.translatable(MESSAGE_IS_Rotten).withStyle(ChatFormatting.RED));



            }


        });

        return true;
    }



}



