package com.null8.nodecore.mixin;

import com.mojang.authlib.GameProfile;
import com.null8.nodecore.common.block.entity.ItemBlockEntity;
import com.null8.nodecore.common.init.NodeCoreBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {

    public ServerPlayerMixin(Level p_36114_, BlockPos p_36115_, float p_36116_, GameProfile p_36117_) {
        super(p_36114_, p_36115_, p_36116_, p_36117_);
    }

    @Contract(mutates = "this")
    @Inject(method = "drop(Lnet/minecraft/world/item/ItemStack;ZZ)Lnet/minecraft/world/entity/item/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void drop(ItemStack itemStack, boolean p_9086_, boolean p_9087_, CallbackInfoReturnable<ItemEntity> cir) {
        if (itemStack == null) {
            cir.setReturnValue(null);
            cir.cancel();
        } else {

            BlockHitResult blockhitresult = getPlayerPOVHitResult(this.getLevel(), this);

            BlockPos blockpos1 = blockhitresult.getBlockPos();
            Direction direction = blockhitresult.getDirection();
            BlockPos blockpos = blockpos1.relative(direction);

            level.setBlock(blockpos, NodeCoreBlocks.ITEM_BLOCK.get().defaultBlockState(), 2); // or 3... idk

            ((ItemBlockEntity) Objects.requireNonNull(level.getBlockEntity(blockpos))).setStackInSlot(0, itemStack);

            if (p_9087_) {
                if (!itemStack.isEmpty()) {
                    this.awardStat(Stats.ITEM_DROPPED.get(itemStack.getItem()), itemStack.getCount());
                }

                this.awardStat(Stats.DROP);
            }

            cir.setReturnValue(null);
            cir.cancel();
        }
    }

    private static BlockHitResult getPlayerPOVHitResult(Level level, Player player) {
        float pitch = player.getXRot();
        float yaw = player.getYRot();
        Vec3 eyePosition = player.getEyePosition();
        float cosYaw = Mth.cos(-yaw * ((float)Math.PI / 180F) - (float)Math.PI);
        float sinYaw = Mth.sin(-yaw * ((float)Math.PI / 180F) - (float)Math.PI);
        float cosPitch = -Mth.cos(-pitch * ((float)Math.PI / 180F));
        float sinPitch = Mth.sin(-pitch * ((float)Math.PI / 180F));
        float sinPitchCosYaw = sinYaw * cosPitch;
        float cosPitchCosYaw = cosYaw * cosPitch;
        double reachDistance = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();
        Vec3 targetPosition = eyePosition.add((double)sinPitchCosYaw * reachDistance, (double)sinPitch * reachDistance, (double)cosPitchCosYaw * reachDistance);
        return level.clip(new ClipContext(eyePosition, targetPosition, ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, player));
    }
}
