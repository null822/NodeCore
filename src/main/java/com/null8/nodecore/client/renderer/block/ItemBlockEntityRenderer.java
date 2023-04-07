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

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack itemStack = BlockEntity.getRenderStack();
        //BlockEntity.lazyItemHandler.invalidate();
        //BlockEntity.tick();

        //ItemStack itemStack = BlockEntity.getHandler().map(inv -> inv.getStackInSlot(0)).orElse(ItemStack.EMPTY);

        if (itemStack == ItemStack.EMPTY || itemStack.getItem().toString().equals("air")) {
            //Minecraft.getInstance().player.chat("Empty!");

        } else {
            Minecraft.getInstance().player.chat("count: " + itemStack.getCount() + " item: " + itemStack.getItem());
        }




        //i++;
        //Minecraft.getInstance().player.chat(Integer.toString(i));

        PoseStack.pushPose();
        PoseStack.translate(0.5f, 0.5f, 0.5f);
        PoseStack.scale(0.25f, 0.25f, 0.25f);


        //pPoseStack.mulPose(Axis.XP.rotationDegrees(90));

        /*
        switch (pBlockEntity.getBlockState().getValue(ItemBlockEntity.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(0));
            case EAST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(90));
            case SOUTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
            case WEST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(270));
        }
         */

        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.NONE, getLightLevel(BlockEntity.getLevel(),
                        BlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, PoseStack, BufferSource, 1);
        PoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
