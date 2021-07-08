package factory.abstractfactory;

import factory.abstractfactory.product.Aircondition;
import factory.abstractfactory.product.Engine;

public interface AbstractFactory {
    Engine createEngine();

    Aircondition createAircondition();
}
