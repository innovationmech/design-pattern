package factory.abstractfactory;

public class Main {

    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        productA1.useA();
        ProductB productB1 = factory1.createProductB();
        productB1.useB();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        productA2.useA();
        ProductB productB2 = factory2.createProductB();
        productB2.useB();
    }
}
