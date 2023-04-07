package com.null8.nodecore.common.block.entity;

import com.null8.nodecore.common.block.entity.util.InventoryBlockEntity;
import com.null8.nodecore.common.init.NodeCoreBlockEntities;
import com.null8.nodecore.networking.ModMessages;
import com.null8.nodecore.networking.packet.ItemStackSyncS2CPacket;
import com.null8.nodecore.util.ForgeCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemBlockEntity extends InventoryBlockEntity {

    private static final int LIMIT = (int) Math.pow(2, 15);
    public LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public ItemBlockEntity(BlockPos pos, BlockState state) {
        super(NodeCoreBlockEntities.ITEM_BLOCK.get(), pos, state, 1);
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            Minecraft.getInstance().player.chat("Contents Changed!");

            if(!level.isClientSide()) {
                ModMessages.sendToClients(new ItemStackSyncS2CPacket(this, worldPosition));
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return true;
        }

    };


    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }


    public ItemStack getRenderStack() {

        Minecraft.getInstance().player.chat(getItemInSlot(0).toString());
        return getItemInSlot(0);

    }

    public void tick() {

        if (this.requiresUpdate && this.level != null) {
            update();
            this.requiresUpdate = false;
        }

    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {


        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }
        }


        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.handler.invalidate();
        lazyItemHandler.invalidate();

    }
}
