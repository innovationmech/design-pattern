package factory.annotated;

@ProductType("B")
public class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Creating Product B");
    }
}
