package factory.abstractfactory;

import factory.abstractfactory.product.Aircondition;
import factory.abstractfactory.product.AirconditionA;
import factory.abstractfactory.product.Engine;
import factory.abstractfactory.product.EngineA;

public class FactoryBWM320 implements AbstractFactory {
    public Engine createEngine() {
        return new EngineA();
    }

    public Aircondition createAircondition() {
        return new AirconditionA();
    }
}
