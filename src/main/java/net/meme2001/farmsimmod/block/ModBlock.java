package net.meme2001.farmsimmod.block;

import net.meme2001.farmsimmod.Farmsimmod;
import net.meme2001.farmsimmod.block.custome.StrawberryCropBlock;
import net.meme2001.farmsimmod.block.custome.TomateoCropBlock;
import net.meme2001.farmsimmod.block.custome.woodenfridage;
import net.meme2001.farmsimmod.item.Moditems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister <Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Farmsimmod.MODID);
    public static final RegistryObject <Block> TOMATEAO_CROP = BLOCKS.register("tomateo_crop", () -> new TomateoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject <Block> WOODEN_FRIDAGE = BLOCKS.register("wooden_fridge", () -> new woodenfridage(BlockBehaviour.Properties.of(Material.WOOD).strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject <Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop", () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));



    public static <T extends Block> RegistryObject <Item> registerBlockItem (String name, RegistryObject<T>block){
        return Moditems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));

    }

    public static <T extends Block> RegistryObject  registerBlock (String name, Supplier<T> block){
       RegistryObject<T> toreturn =BLOCKS.register(name,block);
        registerBlockItem(name,toreturn);
        return toreturn;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);

    }


}

