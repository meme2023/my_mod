package net.meme2001.farmsimmod.item;

import net.meme2001.farmsimmod.Farmsimmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.f_279569_,
            Farmsimmod.MODID);
    public static RegistryObject<CreativeModeTab> FARMSIM_TAB= CREATIVE_MODE_TABS.register("farmsim_tab",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.TOMATEOS.get()))
                    .title(Component.translatable("farm sim tab")).build());



    }


