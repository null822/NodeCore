package com.null8.nodecore.common.init;

import com.null8.nodecore.NodeCore;
import com.null8.nodecore.common.block.blocks.choppy.Log;
import com.null8.nodecore.common.block.blocks.choppy.Planks;
import com.null8.nodecore.common.block.blocks.choppy.Wood;
import com.null8.nodecore.common.block.blocks.cracky.Cobble;
import com.null8.nodecore.common.block.blocks.cracky.Stone;
import com.null8.nodecore.common.block.blocks.cracky.StoneHard;
import com.null8.nodecore.common.block.blocks.crumbly.*;
import com.null8.nodecore.common.block.blocks.other.ItemBlock;
import com.null8.nodecore.common.block.blocks.snappy.Leaves;
import com.null8.nodecore.common.block.blocks.snappy.LeavesLoose;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NodeCoreBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NodeCore.MODID);

    // other
        public static final RegistryObject<Block> ITEM_BLOCK = REGISTRY.register("item_block", ItemBlock::new);

    // cracky
        public static final RegistryObject<Block> STONE = REGISTRY.register("stone", Stone::new);
        public static final RegistryObject<Block> STONE_HARD = REGISTRY.register("stone_hard", StoneHard::new);
        public static final RegistryObject<Block> GRASS_BLOCK = REGISTRY.register("grass_block", GrassBlock::new);
        public static final RegistryObject<Block> COBBLE = REGISTRY.register("cobble", Cobble::new);

    // crumbly
        public static final RegistryObject<Block> DIRT = REGISTRY.register("dirt", Dirt::new);
        public static final RegistryObject<Block> DIRT_LOOSE = REGISTRY.register("dirt_loose", DirtLoose::new);
        public static final RegistryObject<Block> COBBLE_LOOSE = REGISTRY.register("cobble_loose", CobbleLoose::new);
        public static final RegistryObject<Block> GRAVEL = REGISTRY.register("gravel", Gravel::new);
        public static final RegistryObject<Block> GRAVEL_LOOSE = REGISTRY.register("gravel_loose", GravelLoose::new);
        public static final RegistryObject<Block> SAND = REGISTRY.register("sand", Sand::new);
        public static final RegistryObject<Block> SAND_LOOSE = REGISTRY.register("sand_loose", SandLoose::new);

    // choppy
    // acacia
    public static final RegistryObject<Block> LOG_ACACIA = REGISTRY.register("log_acacia", Log::new);
    public static final RegistryObject<Block> LOG_ACACIA_STRIPPED = REGISTRY.register("log_acacia_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_ACACIA = REGISTRY.register("wood_acacia", Wood::new);
    public static final RegistryObject<Block> WOOD_ACACIA_STRIPPED = REGISTRY.register("wood_acacia_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_ACACIA = REGISTRY.register("planks_acacia", Planks::new);
    // birch
    public static final RegistryObject<Block> LOG_BIRCH = REGISTRY.register("log_birch", Log::new);
    public static final RegistryObject<Block> LOG_BIRCH_STRIPPED = REGISTRY.register("log_birch_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_BIRCH = REGISTRY.register("wood_birch", Wood::new);
    public static final RegistryObject<Block> WOOD_BIRCH_STRIPPED = REGISTRY.register("wood_birch_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_BIRCH = REGISTRY.register("planks_birch", Planks::new);
    // dark_oak
    public static final RegistryObject<Block> LOG_DARK_OAK = REGISTRY.register("log_dark_oak", Log::new);
    public static final RegistryObject<Block> LOG_DARK_OAK_STRIPPED = REGISTRY.register("log_dark_oak_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_DARK_OAK = REGISTRY.register("wood_dark_oak", Wood::new);
    public static final RegistryObject<Block> WOOD_DARK_OAK_STRIPPED = REGISTRY.register("wood_dark_oak_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_DARK_OAK = REGISTRY.register("planks_dark_oak", Planks::new);
    // jungle
    public static final RegistryObject<Block> LOG_JUNGLE = REGISTRY.register("log_jungle", Log::new);
    public static final RegistryObject<Block> LOG_JUNGLE_STRIPPED = REGISTRY.register("log_jungle_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_JUNGLE = REGISTRY.register("wood_jungle", Wood::new);
    public static final RegistryObject<Block> WOOD_JUNGLE_STRIPPED = REGISTRY.register("wood_jungle_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_JUNGLE = REGISTRY.register("planks_jungle", Planks::new);
    // oak
    public static final RegistryObject<Block> LOG_OAK = REGISTRY.register("log_oak", Log::new);
    public static final RegistryObject<Block> LOG_OAK_STRIPPED = REGISTRY.register("log_oak_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_OAK = REGISTRY.register("wood_oak", Wood::new);
    public static final RegistryObject<Block> WOOD_OAK_STRIPPED = REGISTRY.register("wood_oak_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_OAK = REGISTRY.register("planks_oak", Planks::new);
    // spruce
    public static final RegistryObject<Block> LOG_SPRUCE = REGISTRY.register("log_spruce", Log::new);
    public static final RegistryObject<Block> LOG_SPRUCE_STRIPPED = REGISTRY.register("log_spruce_stripped", Log::new);
    public static final RegistryObject<Block> WOOD_SPRUCE = REGISTRY.register("wood_spruce", Wood::new);
    public static final RegistryObject<Block> WOOD_SPRUCE_STRIPPED = REGISTRY.register("wood_spruce_stripped", Wood::new);
    public static final RegistryObject<Block> PLANKS_SPRUCE = REGISTRY.register("planks_spruce", Planks::new);

    // snappy
    // acacia
    public static final RegistryObject<Block> LEAVES_ACACIA = REGISTRY.register("leaves_acacia", Leaves::new);
    public static final RegistryObject<Block> LEAVES_ACACIA_LOOSE = REGISTRY.register("leaves_acacia_loose", LeavesLoose::new);
    // birch
    public static final RegistryObject<Block> LEAVES_BIRCH = REGISTRY.register("leaves_birch", Leaves::new);
    public static final RegistryObject<Block> LEAVES_BIRCH_LOOSE = REGISTRY.register("leaves_birch_loose", LeavesLoose::new);
    // dark_oak
    public static final RegistryObject<Block> LEAVES_DARK_OAK = REGISTRY.register("leaves_dark_oak", Leaves::new);
    public static final RegistryObject<Block> LEAVES_DARK_OAK_LOOSE = REGISTRY.register("leaves_dark_oak_loose", LeavesLoose::new);
    // jungle
    public static final RegistryObject<Block> LEAVES_JUNGLE = REGISTRY.register("leaves_jungle", Leaves::new);
    public static final RegistryObject<Block> LEAVES_JUNGLE_LOOSE = REGISTRY.register("leaves_jungle_loose", LeavesLoose::new);
    // oak
    public static final RegistryObject<Block> LEAVES_OAK = REGISTRY.register("leaves_oak", Leaves::new);
    public static final RegistryObject<Block> LEAVES_OAK_LOOSE = REGISTRY.register("leaves_oak_loose", LeavesLoose::new);
    // spruce
    public static final RegistryObject<Block> LEAVES_SPRUCE = REGISTRY.register("leaves_spruce", Leaves::new);
    public static final RegistryObject<Block> LEAVES_SPRUCE_LOOSE = REGISTRY.register("leaves_spruce_loose", LeavesLoose::new);


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            // Rendertype change (mainly for loose blocks with overlay)
            ItemBlock.registerRenderLayer();
            DirtLoose.registerRenderLayer();
            CobbleLoose.registerRenderLayer();
            GravelLoose.registerRenderLayer();
            SandLoose.registerRenderLayer();

            GrassBlock.registerRenderLayer();

            Leaves.registerRenderLayer(LEAVES_ACACIA.get());
            LeavesLoose.registerRenderLayer(LEAVES_ACACIA_LOOSE.get());
            Leaves.registerRenderLayer(LEAVES_BIRCH.get());
            LeavesLoose.registerRenderLayer(LEAVES_BIRCH_LOOSE.get());
            Leaves.registerRenderLayer(LEAVES_DARK_OAK.get());
            LeavesLoose.registerRenderLayer(LEAVES_DARK_OAK_LOOSE.get());
            Leaves.registerRenderLayer(LEAVES_JUNGLE.get());
            LeavesLoose.registerRenderLayer(LEAVES_JUNGLE_LOOSE.get());
            Leaves.registerRenderLayer(LEAVES_OAK.get());
            LeavesLoose.registerRenderLayer(LEAVES_OAK_LOOSE.get());
            Leaves.registerRenderLayer(LEAVES_SPRUCE.get());
            LeavesLoose.registerRenderLayer(LEAVES_SPRUCE_LOOSE.get());

        }

        // Block Color Tint
        @SubscribeEvent
        public static void blockColorLoad(ColorHandlerEvent.Block event) {
            GrassBlock.blockColorLoad(event);
            Leaves.blockColorLoad(event, LEAVES_ACACIA.get());
            LeavesLoose.blockColorLoad(event, LEAVES_ACACIA_LOOSE.get());
            Leaves.blockColorLoad(event, LEAVES_BIRCH.get());
            LeavesLoose.blockColorLoad(event, LEAVES_BIRCH_LOOSE.get());
            Leaves.blockColorLoad(event, LEAVES_DARK_OAK.get());
            LeavesLoose.blockColorLoad(event, LEAVES_DARK_OAK_LOOSE.get());
            Leaves.blockColorLoad(event, LEAVES_JUNGLE.get());
            LeavesLoose.blockColorLoad(event, LEAVES_JUNGLE_LOOSE.get());
            Leaves.blockColorLoad(event, LEAVES_OAK.get());
            LeavesLoose.blockColorLoad(event, LEAVES_OAK_LOOSE.get());
            Leaves.blockColorLoad(event, LEAVES_SPRUCE.get());
            LeavesLoose.blockColorLoad(event, LEAVES_SPRUCE_LOOSE.get());

        }

        // Item Color Tint
        @SubscribeEvent
        public static void itemColorLoad(ColorHandlerEvent.Item event) {
            GrassBlock.itemColorLoad(event);
            Leaves.itemColorLoad(event, LEAVES_ACACIA.get());
            LeavesLoose.itemColorLoad(event, LEAVES_ACACIA_LOOSE.get());
            Leaves.itemColorLoad(event, LEAVES_BIRCH.get());
            LeavesLoose.itemColorLoad(event, LEAVES_BIRCH_LOOSE.get());
            Leaves.itemColorLoad(event, LEAVES_DARK_OAK.get());
            LeavesLoose.itemColorLoad(event, LEAVES_DARK_OAK_LOOSE.get());
            Leaves.itemColorLoad(event, LEAVES_JUNGLE.get());
            LeavesLoose.itemColorLoad(event, LEAVES_JUNGLE_LOOSE.get());
            Leaves.itemColorLoad(event, LEAVES_OAK.get());
            LeavesLoose.itemColorLoad(event, LEAVES_OAK_LOOSE.get());
            Leaves.itemColorLoad(event, LEAVES_SPRUCE.get());
            LeavesLoose.itemColorLoad(event, LEAVES_SPRUCE_LOOSE.get());

        }
    }
}
