package com.null8.nodecore.common.block.entity.util;

import com.null8.nodecore.util.ISlotCallback;
import com.null8.nodecore.util.InventoryItemHandler;
import com.null8.nodecore.util.SidedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class InventoryBlockEntity<C extends IItemHandlerModifiable & INBTSerializable<CompoundTag>> extends NodeCoreBlockEntity implements ISlotCallback {
    protected boolean requiresUpdate;

    protected final C inventory;
    protected final SidedHandler.Builder<IItemHandler> sidedInventory;
    @Nullable protected Component customName;
    protected Component defaultName;

    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, InventoryFactory<C> inventoryFactory, Component defaultName) {
        super(type, pos, state);

        this.inventory = inventoryFactory.create(this);
        this.sidedInventory = new SidedHandler.Builder<>(InventoryBlockEntity.this.inventory);
        this.defaultName = defaultName;
    }

    public Component getDisplayName()
    {
        return customName == null ? defaultName : customName;
    }

    public void setCustomName(Component customName)
    {
        this.customName = customName;
    }


    public static InventoryFactory<ItemStackHandler> defaultInventory(int slots)
    {
        return self -> new InventoryItemHandler(self, slots);
    }


    public ItemStack getItemInSlot(int slot) {
        return inventory.getStackInSlot(slot);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return serializeNBT();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.inventory.deserializeNBT(tag.getCompound("Inventory"));
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }

    public void tick() {

        if (this.requiresUpdate && this.level != null) {
            update();
            this.requiresUpdate = false;
        }



    }

    public void update() {

        requestModelDataUpdate();
        setChanged();
        if (this.level != null) {
            this.level.setBlockAndUpdate(this.worldPosition, getBlockState());
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", this.inventory.serializeNBT());
    }

    @Override
    protected void loadAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.get("Inventory");
    }


    /**
     * A factory interface for the inventory field, allows self references in the constructor
     */
    @FunctionalInterface
    public interface InventoryFactory<C extends IItemHandlerModifiable & INBTSerializable<CompoundTag>>
    {
        C create(InventoryBlockEntity<C> entity);
    }
}
