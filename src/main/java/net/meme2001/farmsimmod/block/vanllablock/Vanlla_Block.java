package net.meme2001.farmsimmod.block.vanllablock;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jline.utils.Log;

public class Vanlla_Block {

    public static final DeferredRegister<Block> VANLLA_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");


    public static void register (IEventBus eventBus){
        VANLLA_BLOCK.register(eventBus);

    }

}
