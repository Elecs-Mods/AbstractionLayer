package elec332.abstraction.impl;

import com.google.common.collect.Sets;
import elec332.abstraction.handlers.IAbstractionLayer;
import elec332.abstraction.handlers.*;
import elec332.core.util.AbstractCreativeTab;
import elec332.core.util.IElecTradeList;
import elec332.core.util.MinecraftList;
import elec332.core.world.IElecWorldEventListener;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static elec332.core.util.ItemStackHelper.NULL_STACK;

/**
 * Created by Elec332 on 28-1-2017.
 */
public final class MCAbstractionHandler implements IAbstractionLayer, IWorldAbstraction, IInventoryAbstraction, IEntityAbstraction, IGeneralAbstraction, IAbstractedClassProvider {

    public MCAbstractionHandler(){
        MinecraftForge.EVENT_BUS.register(this);
    }

    static final Set<IElecWorldEventListener> listeners = Sets.newHashSet();

    @Nonnull
    @Override
    public IAbstractedClassProvider getClassProvider() {
        return this;
    }

    @Nonnull
    @Override
    public Class<? extends IWorldAbstraction> getWorldAbstraction() {
        return this.getClass();
    }

    @Nonnull
    @Override
    public Class<? extends IInventoryAbstraction> getInventoryAbstraction() {
        return this.getClass();
    }

    @Nonnull
    @Override
    public Class<? extends IEntityAbstraction> getEntityAbstraction() {
        return this.getClass();
    }

    @Nonnull
    @Override
    public Class<? extends IGeneralAbstraction> getGeneralAbstraction() {
        return getClass();
    }

    @Override
    public void unRegisterWorldEventListener(IElecWorldEventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void registerWorldEventListener(IElecWorldEventListener listener) {
        listeners.add(listener);
    }

    @Override
    public IBlockState getBlockStateForPlacement(Block block, World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, @Nonnull EnumHand hand) {
        return block.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
    }

    @Override
    public boolean canBlockBePlaced(World world, Block block, BlockPos pos, boolean b, EnumFacing facing, @Nullable Entity entity) {
        return world.mayPlace(block, pos, b, facing, entity);
    }

    @Override
    public void notifyNeighborsOfStateChange(World world, BlockPos pos, Block block) {
        world.notifyNeighborsOfStateChange(pos, block, false);
    }

    @Override
    public <E> List<E> createList() {
        return NonNullList.create();
    }

    @Override
    public <E> List<E> createList(int size, E defaultObj) {
        return NonNullList.withSize(size, defaultObj);
    }

    @Override
    public ItemStack getAndRemove(List<ItemStack> stacks, int index) {
        return ItemStackHelper.getAndRemove(stacks, index);
    }

    @Override
    public ItemStack getAndSplit(List<ItemStack> stacks, int index, int amount) {
        return ItemStackHelper.getAndSplit(stacks, index, amount);
    }

    @Override
    public ItemStack loadItemStackFromNBT(NBTTagCompound tag) {
        return new ItemStack(tag);
    }

    @Override
    public int getSlotStackLimit(IItemHandler itemHandler, int slot) {
        return itemHandler.getSlotLimit(slot);
    }

    @Override
    public ItemStack onPickupFromSlot(Slot slot, EntityPlayer player, ItemStack stack) {
        return slot.onTake(player, stack);
    }

    @Override
    public EnumActionResult fireOnItemUse(Item item, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return item.onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void updateCraftingInventory(IContainerListener listener, Container container, List<ItemStack> itemsList) {
        if (itemsList instanceof MinecraftList){
            itemsList = ((MinecraftList<ItemStack>) itemsList).getUnderlyingList();
        }
        if (!(itemsList instanceof NonNullList)){
            throw new IllegalArgumentException();
        }
        listener.updateCraftingInventory(container, (NonNullList<ItemStack>) itemsList);

    }

    @Override
    public ItemStack getNullStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isStackValid(ItemStack stack) {
        return stack != null && stack != NULL_STACK && !stack.isEmpty && !stack.isEmpty();
    }

    @Nonnull
    @Override
    public ItemStack copyItemStack(@Nullable ItemStack stack) {
        return stack == null || stack == NULL_STACK ? NULL_STACK : stack.copy();
    }

    @Override
    public Entity createEntity(ResourceLocation name, World world) {
        return EntityList.createEntityByIDFromName(new ResourceLocation(name.toString().toLowerCase()), world);
    }

    @Override
    public EntityVillager.ITradeList wrap(IElecTradeList tradeList) {
        return tradeList::modifyMerchantRecipeList;
    }

    @Override
    @Nonnull
    public AbstractCreativeTab create(int index, String label, Supplier<ItemStack> icon) {
        return new MCAbstractedCreativeTab(index, label, icon);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<MCAbstractedAbstractedItem> getAbstractedItemAbstraction() {
        return MCAbstractedAbstractedItem.class;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void loadWorld(WorldEvent.Load event){
        World world = event.getWorld();
        if (!world.isRemote){
            world.removeEventListener(WorldEventListener.INSTANCE);
            world.addEventListener(WorldEventListener.INSTANCE);
        }
    }
    
}
