package net.meme2001.farmsimmod;

import com.mojang.logging.LogUtils;
import net.meme2001.farmsimmod.block.ModBlock;
import net.meme2001.farmsimmod.block.entity.ModBlokEntity;
import net.meme2001.farmsimmod.block.vanllablock.Vanlla_Block;
import net.meme2001.farmsimmod.item.ModCreativeTab;
import net.meme2001.farmsimmod.item.Moditems;
import net.meme2001.farmsimmod.item.VanllaItems;
import net.meme2001.farmsimmod.loot.DeleteItemModifier;
import net.meme2001.farmsimmod.loot.ModLootModifier;
import net.meme2001.farmsimmod.screen.ModMenuTypes;
import net.meme2001.farmsimmod.screen.WoodenFridgeScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.openjdk.nashorn.internal.objects.Global;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Farmsimmod.MODID)
public class Farmsimmod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "farmsimmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Farmsimmod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
          Moditems.register(modEventBus);
          ModBlock.register(modEventBus);
        ModBlokEntity.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        VanllaItems.register(modEventBus);
        ModLootModifier.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


    }



    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if(event.getTab()== ModCreativeTab.FARMSIM_TAB)
        {
            event.accept(Moditems.TOMATEOS);
            event.accept(Moditems.Strewberry);
            event.accept(Moditems.TOMATEO_SEED);
            event.accept(ModBlock.WOODEN_FRIDAGE);
            event.accept(Moditems.STRAWBERRY_SEED);



        }
        if(event.getTab()== CreativeModeTabs.FOOD_AND_DRINKS )

            event.accept(VanllaItems.APPLE);



    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @SuppressWarnings("removal")
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SuppressWarnings("removal")
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //noinspection removal
            ItemBlockRenderTypes.setRenderLayer(ModBlock.TOMATEAO_CROP.get(),RenderType.cutout());
            MenuScreens.register(ModMenuTypes.WOODEN_FRIDGE_MENU.get(), WoodenFridgeScreen::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlock.STRAWBERRY_CROP.get(),RenderType.cutout());




        }

    }

}
