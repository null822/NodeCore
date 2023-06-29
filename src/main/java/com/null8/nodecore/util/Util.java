package com.null8.nodecore.util;

import net.minecraft.world.item.ItemStack;

public class Util {
    public static ItemStack[] mergeStacks(ItemStack mergeTo, ItemStack mergeFrom) {

        if (mergeTo.getMaxStackSize() > 1 && mergeTo.getItem().equals(mergeFrom.getItem())) {

            int storedCount = mergeFrom.getCount();
            int heldCount = mergeTo.getCount();

            int stackLimit = mergeTo.getMaxStackSize();

            int total = storedCount + heldCount;
            int excess = 0;

            if (total > stackLimit) {

                excess = total - stackLimit;
                total = stackLimit;
            }

            ItemStack totalStack = mergeTo.copy();
            ItemStack excessStack = mergeTo.copy();

            totalStack.setCount(total);
            excessStack.setCount(excess);

            return new ItemStack[]{totalStack, excessStack};

        }

        return new ItemStack[]{mergeTo, mergeFrom};
    }

}