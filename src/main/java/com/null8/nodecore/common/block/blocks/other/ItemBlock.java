package com.null8.nodecore.common.block.blocks.other;

import com.null8.nodecore.common.api.FallingBlock;
import com.null8.nodecore.common.block.entity.ItemBlockEntity;
import com.null8.nodecore.common.init.NodeCoreBlockEntities;
import com.null8.nodecore.common.init.NodeCoreBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.network.NetworkHooks;

import static com.null8.nodecore.common.block.entity.ItemBlockEntity.containedItem;

public class ItemBlock extends FallingBlock implements SimpleWaterloggedBlock, EntityBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ItemBlock() {
        super(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.NONE).sound(SoundType.WOOD).strength(1f, 10f).noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false).dynamicShape());
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }



    @OnlyIn(Dist.CLIENT)
    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(NodeCoreBlocks.ITEM_BLOCK.get(), renderType -> renderType == RenderType.translucent());
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
        return true;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(4, 0, 4, 12, 8, 12).move(offset.x, offset.y, offset.z);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return this.defaultBlockState().setValue(WATERLOGGED, flag);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
                                  BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack(Blocks.AIR); // set to contents
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {

            level.updateNeighbourForOutputSignal(pos, this);

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level level, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {

        if (entity != null && level.getBlockEntity(pos) instanceof final ItemBlockEntity itemblock) {

            ItemStack stack = itemblock.getItemInSlot(0);

            Minecraft.getInstance().player.chat("" + stack.getItem()  + " " + stack.getCount());

            ItemHandlerHelper.giveItemToPlayer(entity, stack);
        }

        return super.onDestroyedByPlayer(blockstate, level, pos, entity, willHarvest, fluid);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    /*
    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final ItemBlockEntity itemblock) {
            if (player.isCrouching()) {
                itemblock.prependStack(player);
            } else {
                itemblock.prependItem(player);
            }
        }
    }
    */

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
                                                                  BlockEntityType<T> beType) {
        return level.isClientSide ? null
                : (level0, pos, state0, blockEntity) -> ((ItemBlockEntity) blockEntity).tick();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return NodeCoreBlockEntities.ITEM_BLOCK.get().create(pos, state);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult result) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final ItemBlockEntity itemblock) {
            if (!player.isCrouching()) {

                BlockEntity be = level.getBlockEntity(pos);

                NetworkHooks.openGui(((ServerPlayer)player), (MenuProvider) be, pos);


                // get stacks
                ItemStack stack = player.getItemInHand(hand);
                ItemStack contained = itemblock.getItemInSlot(0);

                // get values
                int max = contained.getMaxStackSize();
                int remainingSpace = max - contained.getCount();

                ItemStack remainingStack = stack.copy();

                // calculate remaining items
                remainingStack.setCount(remainingStack.getCount() - remainingSpace);
                stack.setCount(remainingSpace);

                // insert items
                player.setItemInHand(hand, remainingStack);
                itemblock.insertItem(0, stack);

                containedItem = itemblock.getItemInSlot(0);


                Minecraft.getInstance().player.chat("remainingStack: " + remainingStack + " stack: " + stack);

            } else {
                Minecraft.getInstance().player.chat("count: " + itemblock.getItemInSlot(0).getCount() + " item: " + itemblock.getItemInSlot(0).getItem());

            }

            itemblock.update();
        }


        return InteractionResult.SUCCESS;

    }


}
