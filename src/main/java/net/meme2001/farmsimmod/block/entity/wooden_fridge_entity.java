package net.meme2001.farmsimmod.block.entity;

import net.meme2001.farmsimmod.item.Moditems;
import net.meme2001.farmsimmod.item.VanllaItems;
import net.meme2001.farmsimmod.screen.WoodenFridgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static net.meme2001.farmsimmod.item.Moditems.*;
import static net.minecraft.world.item.Item.getId;
public class wooden_fridge_entity extends BlockEntity implements MenuProvider {
    private ContainerData data;


    public wooden_fridge_entity(BlockPos pos, BlockState state) {
        super(ModBlokEntity.WOODEN_FRIDAGE.get(), pos, state);
    }




    private final ItemStackHandler itemstackhandler = new ItemStackHandler(18) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
          if(slot <= 18  &&stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Strewberry.get()|| stack.getItem() == VanllaItems.APPLE.get())

              return true;
            /*return switch (slot) {
                case 0 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Strewberry.get()|| stack.getItem() == VanllaItems.APPLE.get();
                case 1 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get() ;
                case 2 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 3 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 4 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 5-> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 6 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 7 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 8 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 9 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 10 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 11-> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 12-> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 13 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;
                case 14 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 15 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get();
                case 16 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get() ||stack.getItem() == VanllaItems.APPLE.get();
                case 17 -> stack.getItem() == Moditems.TOMATEOS.get() || stack.getItem() == Moditems.Strewberry.get()||stack.getItem() == VanllaItems.APPLE.get() ;


                default -> throw new IllegalStateException("Unexpected value: " + slot);
            };*/
            return false;
        }

    };

        private LazyOptional<IItemHandler> LazyItemHandler = LazyOptional.empty();

        @Override
        public Component getDisplayName() {
            return Component.literal("Wooden fridge");
        }


        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            if (cap == ForgeCapabilities.ITEM_HANDLER) {
                return LazyItemHandler.cast();
            }
            return super.getCapability(cap, side);
        }

        @Override
        public void onLoad() {
            super.onLoad();
            LazyItemHandler = LazyOptional.of(() -> itemstackhandler);
        }

        @Override
        public void invalidateCaps() {
            super.invalidateCaps();
            LazyItemHandler.invalidate();
        }

        @Override
        protected void saveAdditional(CompoundTag nbt) {
            nbt.put("inventory", itemstackhandler.serializeNBT());
            super.saveAdditional(nbt);
        }

        @Override
        public void load(CompoundTag nbt) {
            super.load(nbt);
            itemstackhandler.deserializeNBT(nbt.getCompound("inventory"));
        }


        public void drops() {
            SimpleContainer inventory = new SimpleContainer(itemstackhandler.getSlots());
            for (int i = 0; i < itemstackhandler.getSlots(); i++) {
                inventory.setItem(i, itemstackhandler.getStackInSlot(i));
            }

            Containers.dropContents(this.level, this.worldPosition, inventory);
        }

        @Nullable
        @Override
        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
            return new WoodenFridgeMenu(id, inventory, this, this.data);
        }


    }



