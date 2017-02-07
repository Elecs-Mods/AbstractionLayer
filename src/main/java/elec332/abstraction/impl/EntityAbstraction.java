package elec332.abstraction.impl;

import elec332.abstraction.handlers.IEntityAbstraction;
import elec332.core.util.IElecTradeList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Elec332 on 6-2-2017.
 */
public class EntityAbstraction implements IEntityAbstraction {

    @Override
    public Entity createEntity(ResourceLocation name, World world) {
        return EntityList.createEntityByIDFromName(name.getResourcePath(), world);
    }

    @Override
    public EntityVillager.ITradeList wrap(Object tradeList) {
        return new MCAbstractedTrade((IElecTradeList) tradeList);
    }

}
