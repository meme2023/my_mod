package net.meme2001.farmsimmod;

import net.meme2001.farmsimmod.networking.ModPacket;
import net.meme2001.farmsimmod.networking.packet.DaysC2SPacket;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Farmsimmod.MODID)

    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingHurt(LevelEvent event) {

                if (event.getLevel()instanceof Level level) {
                    long day =level.getDayTime()%72002;
                    long l = level.getLevelData().getDayTime() % 72000;
                    day*=2%2;


                    if(day>72000) {


                        ModPacket.SendToSever(new DaysC2SPacket());



                    }
                    else
                        event.isCanceled();


                }
            }
        }
    }
