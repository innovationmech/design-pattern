package factory.simplefactory;

import factory.simplefactory.product.BWM;

public class Customer {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BWM bwm320 = factory.createBWM(320);
        BWM bwm523 = factory.createBWM(523);
    }
}
