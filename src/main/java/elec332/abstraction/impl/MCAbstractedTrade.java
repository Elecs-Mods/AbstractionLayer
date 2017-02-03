package elec332.abstraction.impl;

import elec332.core.util.IElecTradeList;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipeList;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Created by Elec332 on 3-2-2017.
 */
public class MCAbstractedTrade implements EntityVillager.ITradeList {

    public MCAbstractedTrade(IElecTradeList trade){
        this.trade = trade;
    }

    private final IElecTradeList trade;

    @Override
    public void modifyMerchantRecipeList(@Nonnull MerchantRecipeList recipeList, @Nonnull Random random) {
        trade.modifyMerchantRecipeList(null, recipeList, random);
    }

}
