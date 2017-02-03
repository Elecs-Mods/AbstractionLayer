package elec332.abstraction.impl;

import elec332.core.util.AbstractCreativeTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

/**
 * Created by Elec332 on 30-1-2017.
 */
public class MCAbstractedCreativeTab extends AbstractCreativeTab {

    public MCAbstractedCreativeTab(int index, String label, Supplier<ItemStack> icon) {
        super(index, label);
        this.icon = icon;
        initStack();
    }

    @SideOnly(Side.CLIENT)
    private ItemStack clientStack;
    private final Supplier<ItemStack> icon;

    private void initStack(){
        if (FMLCommonHandler.instance().getSide().isClient()){
            clientStack = icon.get();
        }
    }

    @Override
    @Nonnull
    public ItemStack getIconItemStack() {
        return clientStack;
    }

    @SideOnly(Side.CLIENT)
    @Override
    @Nonnull
    public final Item getTabIconItem() {
        return clientStack.getItem();
    }

    @Override
    public int getIconItemDamage() {
        return clientStack.getItemDamage();
    }

    @Nonnull
    @Override
    protected ItemStack getDisplayStack() {
        return clientStack;
    }

}