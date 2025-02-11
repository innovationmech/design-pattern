package factory.simplefactory;

public class Main {

    public static void main(String[] args) {
        Product productA = ProductFactory.getProduct("A");
        productA.use();

        Product productB = ProductFactory.getProduct("B");
        productB.use();
    }
}
