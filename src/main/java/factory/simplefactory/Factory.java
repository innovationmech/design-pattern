package factory.simplefactory;

import factory.simplefactory.product.BWM;
import factory.simplefactory.product.BWM320;
import factory.simplefactory.product.BWM523;

public class Factory {
    public BWM createBWM(int type) {
        switch (type) {
            case 320:
                return new BWM320();
            case 523:
                return new BWM523();
            default:
                break;
        }
        return null;
    }
}
