package net.meme2001.farmsimmod.loot;

import com.mojang.serialization.Codec;
import net.meme2001.farmsimmod.Farmsimmod;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,Farmsimmod.MODID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DELETE_ITEM = LOOT_MODIFIER_SERIALIZERS.register("delete_item", DeleteItemModifier.CODEC);




        public static void register (IEventBus bus){
            LOOT_MODIFIER_SERIALIZERS.register(bus);

        }
    }
