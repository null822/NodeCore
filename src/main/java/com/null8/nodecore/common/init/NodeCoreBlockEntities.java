
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.null8.nodecore.common.init;

import com.null8.nodecore.NodeCore;
import com.null8.nodecore.common.block.entity.ItemBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NodeCoreBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, NodeCore.MODID);

    //public static final RegistryObject<BlockEntityType<?>> ITEM_BLOCK = register("item_block", NodeCoreBlocks.ITEM_BLOCK, ItemBlock::new);

    public static final RegistryObject<BlockEntityType<ItemBlockEntity>> ITEM_BLOCK = BLOCK_ENTITIES.register(
            "item_block",
            () -> BlockEntityType.Builder.of(ItemBlockEntity::new, NodeCoreBlocks.ITEM_BLOCK.get()).build(null));

    private NodeCoreBlockEntities() {
    }
}
