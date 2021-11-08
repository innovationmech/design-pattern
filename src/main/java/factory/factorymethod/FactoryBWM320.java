package factory.factorymethod;

import factory.simplefactory.product.BWM320;

public class FactoryBWM320 {

    public BWM320 createBWM() {
        return new BWM320();
    }
}
