package net.meme2001.farmsimmod.block.entity;


import net.meme2001.farmsimmod.Farmsimmod;
import net.meme2001.farmsimmod.block.ModBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlokEntity
{
    public static  final DeferredRegister <BlockEntityType<?>> BLOCK_ENTITIES= DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES , Farmsimmod.MODID);
    public static final RegistryObject<BlockEntityType<wooden_fridge_entity>> WOODEN_FRIDAGE = BLOCK_ENTITIES.register("wooden_fridge", () -> BlockEntityType.Builder.of(wooden_fridge_entity::new, ModBlock.WOODEN_FRIDAGE.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);

    }

}
