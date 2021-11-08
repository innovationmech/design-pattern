package factory.abstractfactory;

public class Customer3 {
    public static void main(String[] args) {
        // 生产宝马320系列配件
        AbstractFactory factoryBWM320 = new FactoryBWM320();
        factoryBWM320.createEngine();
        factoryBWM320.createAircondition();

        // 生产宝马523系列配件
        AbstractFactory factoryBWM523 = new FactoryBWM523();
        factoryBWM523.createEngine();
        factoryBWM523.createAircondition();
    }
}
