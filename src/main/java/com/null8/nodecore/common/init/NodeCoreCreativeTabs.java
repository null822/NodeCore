package com.null8.nodecore.common.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class NodeCoreCreativeTabs {
    public static final CreativeModeTab BLOCKS = new CreativeModeTab("NodeCore") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NodeCoreItems.COBBLE.get());
        }
    };
}
