package elec332.abstraction.impl;

import elec332.core.util.FMLUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

/**
 * Created by Elec332 on 5-2-2017.
 */
public class MCAbstractionInst {

    public static CreativeTabs createTab_(int index, String label, Supplier<ItemStack> icon) {

        try {
            Class c = FMLUtil.loadClass("elec332.abstraction.impl.MCAbstractedCreativeTab");
            return (CreativeTabs) c.getConstructor(int.class, String.class, Supplier.class).newInstance(index, label, icon);
        } catch (Exception e){
            throw new RuntimeException();
        }

        //re
        // turn new MCAbstractedCreativeTab(index, label, icon);
    }

}
