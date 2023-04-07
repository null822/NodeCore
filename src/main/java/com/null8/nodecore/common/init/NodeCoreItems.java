package com.null8.nodecore.common.init;

import com.null8.nodecore.NodeCore;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NodeCoreItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NodeCore.MODID);

    // other
    public static final RegistryObject<Item> ITEM_BLOCK = block(NodeCoreBlocks.ITEM_BLOCK, null);

    // cracky
    public static final RegistryObject<Item> STONE = block(NodeCoreBlocks.STONE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> STONE_HARD = block(NodeCoreBlocks.STONE_HARD, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> GRASS_BLOCK = block(NodeCoreBlocks.GRASS_BLOCK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> COBBLE = block(NodeCoreBlocks.COBBLE, NodeCoreCreativeTabs.BLOCKS);

    // crumbly
    public static final RegistryObject<Item> DIRT = block(NodeCoreBlocks.DIRT, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> DIRT_LOOSE = block(NodeCoreBlocks.DIRT_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> COBBLE_LOOSE = block(NodeCoreBlocks.COBBLE_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> GRAVEL = block(NodeCoreBlocks.GRAVEL, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> GRAVEL_LOOSE = block(NodeCoreBlocks.GRAVEL_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> SAND = block(NodeCoreBlocks.SAND, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> SAND_LOOSE = block(NodeCoreBlocks.SAND_LOOSE, NodeCoreCreativeTabs.BLOCKS);

    // choppy
    // acacia
    public static final RegistryObject<Item> LOG_ACACIA = block(NodeCoreBlocks.LOG_ACACIA, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_ACACIA_STRIPPED = block(NodeCoreBlocks.LOG_ACACIA_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_ACACIA = block(NodeCoreBlocks.WOOD_ACACIA, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_ACACIA_STRIPPED = block(NodeCoreBlocks.WOOD_ACACIA_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_ACACIA = block(NodeCoreBlocks.PLANKS_ACACIA, NodeCoreCreativeTabs.BLOCKS);
    // birch
    public static final RegistryObject<Item> LOG_BIRCH = block(NodeCoreBlocks.LOG_BIRCH, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_BIRCH_STRIPPED = block(NodeCoreBlocks.LOG_BIRCH_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_BIRCH = block(NodeCoreBlocks.WOOD_BIRCH, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_BIRCH_STRIPPED = block(NodeCoreBlocks.WOOD_BIRCH_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_BIRCH = block(NodeCoreBlocks.PLANKS_BIRCH, NodeCoreCreativeTabs.BLOCKS);
    // dark_oak
    public static final RegistryObject<Item> LOG_DARK_OAK = block(NodeCoreBlocks.LOG_DARK_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_DARK_OAK_STRIPPED = block(NodeCoreBlocks.LOG_DARK_OAK_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_DARK_OAK = block(NodeCoreBlocks.WOOD_DARK_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_DARK_OAK_STRIPPED = block(NodeCoreBlocks.WOOD_DARK_OAK_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_DARK_OAK = block(NodeCoreBlocks.PLANKS_DARK_OAK, NodeCoreCreativeTabs.BLOCKS);
    // jungle
    public static final RegistryObject<Item> LOG_JUNGLE = block(NodeCoreBlocks.LOG_JUNGLE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_JUNGLE_STRIPPED = block(NodeCoreBlocks.LOG_JUNGLE_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_JUNGLE = block(NodeCoreBlocks.WOOD_JUNGLE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_JUNGLE_STRIPPED = block(NodeCoreBlocks.WOOD_JUNGLE_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_JUNGLE = block(NodeCoreBlocks.PLANKS_JUNGLE, NodeCoreCreativeTabs.BLOCKS);
    // oak
    public static final RegistryObject<Item> LOG_OAK = block(NodeCoreBlocks.LOG_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_OAK_STRIPPED = block(NodeCoreBlocks.LOG_OAK_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_OAK = block(NodeCoreBlocks.WOOD_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_OAK_STRIPPED = block(NodeCoreBlocks.WOOD_OAK_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_OAK = block(NodeCoreBlocks.PLANKS_OAK, NodeCoreCreativeTabs.BLOCKS);
    // spruce
    public static final RegistryObject<Item> LOG_SPRUCE = block(NodeCoreBlocks.LOG_SPRUCE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LOG_SPRUCE_STRIPPED = block(NodeCoreBlocks.LOG_SPRUCE_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_SPRUCE = block(NodeCoreBlocks.WOOD_SPRUCE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> WOOD_SPRUCE_STRIPPED = block(NodeCoreBlocks.WOOD_SPRUCE_STRIPPED, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PLANKS_SPRUCE = block(NodeCoreBlocks.PLANKS_SPRUCE, NodeCoreCreativeTabs.BLOCKS);

    // snappy
    // acacia
    public static final RegistryObject<Item> LEAVES_ACACIA = block(NodeCoreBlocks.LEAVES_ACACIA, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_ACACIA_LOOSE = block(NodeCoreBlocks.LEAVES_ACACIA_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    // birch
    public static final RegistryObject<Item> LEAVES_BIRCH = block(NodeCoreBlocks.LEAVES_BIRCH, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_BIRCH_LOOSE = block(NodeCoreBlocks.LEAVES_BIRCH_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    // dark_oak
    public static final RegistryObject<Item> LEAVES_DARK_OAK = block(NodeCoreBlocks.LEAVES_DARK_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_DARK_OAK_LOOSE = block(NodeCoreBlocks.LEAVES_DARK_OAK_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    // jungle
    public static final RegistryObject<Item> LEAVES_JUNGLE = block(NodeCoreBlocks.LEAVES_JUNGLE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_JUNGLE_LOOSE = block(NodeCoreBlocks.LEAVES_JUNGLE_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    // oak
    public static final RegistryObject<Item> LEAVES_OAK = block(NodeCoreBlocks.LEAVES_OAK, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_OAK_LOOSE = block(NodeCoreBlocks.LEAVES_OAK_LOOSE, NodeCoreCreativeTabs.BLOCKS);
    // spruce
    public static final RegistryObject<Item> LEAVES_SPRUCE = block(NodeCoreBlocks.LEAVES_SPRUCE, NodeCoreCreativeTabs.BLOCKS);
    public static final RegistryObject<Item> LEAVES_SPRUCE_LOOSE = block(NodeCoreBlocks.LEAVES_SPRUCE_LOOSE, NodeCoreCreativeTabs.BLOCKS);


    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}
