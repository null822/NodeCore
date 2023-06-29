package com.null8.nodecore.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.null8.nodecore.common.block.entity.ItemBlockEntity;
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

public class ItemBlockEntityRenderer implements BlockEntityRenderer<ItemBlockEntity> {

    public ItemBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(ItemBlockEntity BlockEntity, float PartialTick, PoseStack PoseStack, MultiBufferSource BufferSource,
                       int PackedLight, int PackedOverlay) {
        if (BlockEntity.getLevel() == null) return;
        ItemStack itemStack = BlockEntity.getRenderStack();

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        PoseStack.pushPose();

        final float size = (float) itemStack.getCount() / itemStack.getMaxStackSize() / 4 + 0.25f;


        PoseStack.translate(0.5f, 0.5-(1-size)/2, 0.5f);
        PoseStack.scale(size, size, size);



        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.NONE, getLightLevel(BlockEntity.getLevel(),
                        BlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, PoseStack, BufferSource, 1);

        PoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
