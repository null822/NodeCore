package com.null8.nodecore.common.block.blocks.cracky;

import com.null8.nodecore.common.init.NodeCoreBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

import static com.null8.nodecore.common.api.Mining.replaceblock;

public class Stone extends Block {

    public Stone() {
        super(Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(2.0f, 6.0f));
    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, LootContext.@NotNull Builder builder) {

        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }


    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        return replaceblock(NodeCoreBlocks.COBBLE.get(), this.asBlock(), state, 8f, level, pos, player, willHarvest);
    }
}
