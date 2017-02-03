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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Elec332 on 29-1-2017.
 */
public class MCAbstractedBlock extends Block implements IAbstractedBlock {

    public MCAbstractedBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public MCAbstractedBlock(Material materialIn) {
        super(materialIn);
    }

    @Override
    public boolean onBlockActivatedC(World world, BlockPos pos, EntityPlayer player, EnumHand hand, IBlockState state, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    public void neighborChangedC(World world, BlockPos pos, IBlockState state, Block neighbor, @Nullable BlockPos fromPos) {
    }

    @Nonnull
    @Override
    @SuppressWarnings("all")
    public IBlockState getBlockStateForPlacementC(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, @Nullable EnumHand hand) {
        return null;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBoxC(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, IBlockState state) {
        return null;
    }

    @Override
    public void getSubBlocksC(@Nonnull Item item, List<ItemStack> subBlocks, CreativeTabs creativeTab) {
    }

}
