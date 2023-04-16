package com.null8.nodecore.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.null8.nodecore.common.block.entity.ItemBlockEntity;
import com.null8.nodecore.util.Capabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;

public class ItemBlockEntityRenderer implements BlockEntityRenderer<ItemBlockEntity> {

    public ItemBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(ItemBlockEntity BlockEntity, float PartialTick, PoseStack PoseStack, MultiBufferSource BufferSource,
                       int PackedLight, int PackedOverlay) {
        if (BlockEntity.getLevel() == null) return;
        BlockEntity.getCapability(Capabilities.ITEM).ifPresent(cap -> {
            BlockState state = BlockEntity.getBlockState();

            //ItemStack itemStack = cap.getStackInSlot(0);
            ItemStack itemStack = BlockEntity.getRenderStack();

            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

            //BlockEntity.lazyItemHandler.invalidate();
            //BlockEntity.tick();

            //ItemStack itemStack = BlockEntity.getHandler().map(inv -> inv.getStackInSlot(0)).orElse(ItemStack.EMPTY);

            PoseStack.pushPose();


            PoseStack.translate(0.5f, 0.5f, 0.5f);
            PoseStack.scale(0.25f, 0.25f, 0.25f);



            itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.NONE, getLightLevel(BlockEntity.getLevel(),
                            BlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, PoseStack, BufferSource, 1);

            PoseStack.popPose();

            });

    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
