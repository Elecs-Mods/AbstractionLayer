package elec332.abstraction.impl;

import elec332.abstraction.object.IAbstractedWorldProvider;
import net.minecraft.world.WorldProvider;

/**
 * Created by Elec332 on 29-1-2017.
 */
public abstract class MCAbstractedWorldProvider extends WorldProvider implements IAbstractedWorldProvider {

    @Override
    protected final void init() {
        setup();
    }

    @Override
    public void setup() {
        super.init();
    }

}
