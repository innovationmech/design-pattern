package factory.factorymethod;

import factory.simplefactory.product.BWM320;

public class FactoryBWM320 implements FactoryBWM {

    @Override
    public BWM320 createBWM() {
        return new BWM320();
    }
}
