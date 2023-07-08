package net.meme2001.farmsimmod.block.vanllablock;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Vanlla_Block {

    public static final DeferredRegister<Block> VANLLA_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");


    public static void register (IEventBus eventBus){
        VANLLA_BLOCK.register(eventBus);

    }

}
