package net.meme2001.farmsimmod.item;

import net.meme2001.farmsimmod.Farmsimmod;
import net.meme2001.farmsimmod.block.ModBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VanllaItems {
    public static final DeferredRegister<Item> VANLLA_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Farmsimmod.MODID);
    public static final RegistryObject<Item> APPLE = VANLLA_ITEM.register("apple",() -> new Item(new Item.Properties()));





    public static void register (IEventBus eventBus){
        VANLLA_ITEM.register(eventBus);

    }
}
