package net.meme2001.farmsimmod.item;

import net.meme2001.farmsimmod.Farmsimmod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Farmsimmod.MODID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {
    public static CreativeModeTab FARMSIM_TAB;


    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        FARMSIM_TAB = event.registerCreativeModeTab(new ResourceLocation(Farmsimmod.MODID, "farmsim_tab"),
                builder -> builder.icon(() -> new ItemStack(Moditems.TOMATEOS.get()))
                        .title(Component.translatable("farm sim tab")));

    }

}
