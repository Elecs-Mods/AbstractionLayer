package elec332.abstraction.impl;

import elec332.abstraction.object.IAbstractedBlock;
import elec332.abstraction.object.IAbstractedItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Elec332 on 29-1-2017.
 */
@SuppressWarnings("deprecation")
public class MCAbstractedBlock extends Block implements IAbstractedBlock {

    public MCAbstractedBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public MCAbstractedBlock(Material materialIn) {
        super(materialIn);
    }

    @Override
    public final boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onBlockActivatedC(world, pos, player, hand, state, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean onBlockActivatedC(World world, BlockPos pos, EntityPlayer player, EnumHand hand, IBlockState state, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(world, pos, state, player, hand, player.getHeldItem(hand), facing, hitX, hitY, hitZ);
    }

    @Override
    @SuppressWarnings("deprecation")
    public final void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        neighborChangedC(worldIn, pos, state, blockIn, null);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborChangedC(World world, BlockPos pos, IBlockState state, Block neighbor, BlockPos p_189540_5_) {
        super.neighborChanged(state, world, pos, neighbor);
    }

    @Override
    public final IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getBlockStateForPlacementC(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer, null);
    }

    @Override
    @Nonnull
    public IBlockState getStateForPlacement(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ, int meta, @Nonnull EntityLivingBase placer, ItemStack stack) {
        return this.getBlockStateForPlacementC(world, pos, facing, hitX, hitY, hitZ, meta, placer, null);
    }

    @Override
    @Nonnull
    public IBlockState getBlockStateForPlacementC(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, @Nullable EnumHand hand) {
        if (hand == null) {
            return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer);
        } else {
            return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, placer.getHeldItem(hand));
        }
    }

    @Nullable
    @Override
    public final AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, @Nonnull World worldIn, @Nonnull BlockPos pos) {
        return getCollisionBoundingBoxC(worldIn, pos, blockState);
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBoxC(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, IBlockState state) {
        return super.getCollisionBoundingBox(state, (World) world, pos);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public final void getSubBlocks(@Nonnull Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        getSubBlocksC(itemIn, list, tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocksC(@Nonnull Item item, List<ItemStack> subBlocks, CreativeTabs creativeTab) {
        super.getSubBlocks(item, creativeTab, subBlocks);
    }

}
