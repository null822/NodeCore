package com.null8.nodecore.common.init;

import com.null8.nodecore.NodeCore;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class NodeCoreBlockTags  {

    public static final TagKey<Block> LOOSE = create("loose");
    public static final TagKey<Block> LEAVES = create("leaves");


    private static TagKey<Block> create(String location) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(location));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, name);
    }
}

