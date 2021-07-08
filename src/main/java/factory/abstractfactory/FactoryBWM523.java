package factory.abstractfactory;

import factory.abstractfactory.product.Aircondition;
import factory.abstractfactory.product.AirconditionB;
import factory.abstractfactory.product.Engine;
import factory.abstractfactory.product.EngineB;

public class FactoryBWM523 implements AbstractFactory {
    public Engine createEngine() {
        return new EngineB();
    }

    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
