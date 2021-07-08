package factory.factorymethod;

import factory.simplefactory.product.BWM523;

public class FactoryBWM523 implements FactoryBWM {

    @Override
    public BWM523 createBWM() {
        return new BWM523();
    }
}
