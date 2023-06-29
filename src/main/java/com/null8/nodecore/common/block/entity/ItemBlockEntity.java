package com.null8.nodecore.common.block.entity;

import com.null8.nodecore.common.block.entity.util.InventoryBlockEntity;
import com.null8.nodecore.common.init.NodeCoreBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Objects;

import static com.null8.nodecore.NodeCore.MODID;
import static com.null8.nodecore.util.Util.mergeStacks;

public class ItemBlockEntity extends InventoryBlockEntity<ItemStackHandler> {

    private static final Component NAME = new TranslatableComponent(MODID + ".block_entity.tool_rack");

    public ItemBlockEntity(BlockPos pos, BlockState state) {
        super(NodeCoreBlockEntities.ITEM_BLOCK.get(), pos, state, defaultInventory(1), NAME);
    }


    public ItemStack getRenderStack() {
        return getItemInSlot(0);
    }

    public void tick() {

        if (this.requiresUpdate && this.level != null) {
            update();
            this.requiresUpdate = false;
        }

    }

    public InteractionResult onRightClick(Player player, int slot)
    {
        assert level != null;
        final ItemStack heldItem;

        if (!player.isShiftKeyDown()) {
            heldItem = player.getMainHandItem().copy();
        } else {
            heldItem = player.getMainHandItem().split(1).copy();
        }

        final boolean shouldExtract = !inventory.getStackInSlot(slot).isEmpty();
        final boolean shouldInsert = !heldItem.isEmpty();

        if (shouldExtract) {
            if (shouldInsert) {
                // Merge stacks
                if (heldItem.getMaxStackSize() > 1 && heldItem.getItem().equals(inventory.getStackInSlot(slot).getItem())) {

                    if (inventory.getStackInSlot(slot).getCount() == inventory.getStackInSlot(slot).getMaxStackSize()) {
                        ItemStack[] stacks = mergeStacks(inventory.getStackInSlot(slot), heldItem);

                        inventory.setStackInSlot(slot, stacks[1]);
                        player.setItemInHand(player.getUsedItemHand(), stacks[0]);

                    } else {
                        ItemStack[] stacks = mergeStacks(inventory.getStackInSlot(slot), heldItem);

                        inventory.setStackInSlot(slot, stacks[0]);
                        player.setItemInHand(player.getUsedItemHand(), stacks[1]);
                    }

                    player.playSound(SoundEvents.WOOD_PLACE, 1, 1);
                    update();

                    // Swap stacks
                } else if (!heldItem.equals(inventory.getStackInSlot(slot))) {

                    final ItemStack extracted = inventory.extractItem(slot, inventory.getStackInSlot(slot).getCount(), false);
                    inventory.insertItem(slot, heldItem, false);
                    player.setItemInHand(player.getUsedItemHand(), extracted);

                    player.playSound(SoundEvents.WOOD_PLACE, 1, 1);
                    update();
                }
            } else {

                // Just extract
                final ItemStack extracted = inventory.extractItem(slot, inventory.getStackInSlot(slot).getCount(), false);
                player.setItemInHand(player.getUsedItemHand(), extracted);

                player.playSound(SoundEvents.WOOD_PLACE, 1, 1);
                update();
            }
        } else {
            if (shouldInsert) {
                // Just insert
                final ItemStack remaining = inventory.insertItem(slot, heldItem, false);
                player.setItemInHand(player.getUsedItemHand(), remaining);

                player.playSound(SoundEvents.WOOD_PLACE, 1, 1);
                update();
            } else {
                return InteractionResult.FAIL;
            }
        }

        if (this.inventory.getStackInSlot(0) == ItemStack.EMPTY) {
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), Blocks.AIR.defaultBlockState(), 0);
        }

        return InteractionResult.SUCCESS;
    }

    public void setStackInSlot(int slot, ItemStack itemStack) {
        inventory.setStackInSlot(slot, itemStack);
        update();
    }
}
