package factory.factorymethod;

import factory.simplefactory.product.BWM320;
import factory.simplefactory.product.BWM523;

public class Customer2 {
    public static void main(String[] args) {
        FactoryBWM320 factoryBWM320 = new FactoryBWM320();
        BWM320 bwm320 = factoryBWM320.createBWM();

        FactoryBWM523 factoryBWM523 = new FactoryBWM523();
        BWM523 bwm523 = factoryBWM523.createBWM();
    }
}
