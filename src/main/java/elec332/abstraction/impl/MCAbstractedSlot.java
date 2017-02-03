package elec332.abstraction.impl;

import elec332.abstraction.object.IAbstractedSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * Created by Elec332 on 30-1-2017.
 */
public class MCAbstractedSlot extends Slot implements IAbstractedSlot {

    public MCAbstractedSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public void onSwapCraftC(int count) {
    }

    @Override
    public final void onPickupFromSlot(EntityPlayer p_190901_1_, @Nonnull ItemStack p_190901_2_) {
        onTakenFromSlotC(p_190901_1_, p_190901_2_);
    }

    @Nonnull
    @Override
    public ItemStack onTakenFromSlotC(EntityPlayer player, ItemStack stack) {
        super.onPickupFromSlot(player, stack);
        return stack;
    }

}
