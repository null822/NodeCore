package com.null8.nodecore.common.block.blocks.crumbly;

import com.null8.nodecore.common.api.UnstableBlock;
import com.null8.nodecore.common.init.NodeCoreBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class CobbleLoose extends UnstableBlock {

    public CobbleLoose() {
        super(Properties.of(Material.DIRT, MaterialColor.STONE).randomTicks().sound(SoundType.GRAVEL).strength(0.5f));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(NodeCoreBlocks.COBBLE_LOOSE.get(), renderType -> renderType == RenderType.translucent());
    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootContext.@NotNull Builder builder) {

        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }
}
