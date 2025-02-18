package factory.annotated;

public class Main {

    public static void main(String[] args) {
        try {
            Product productA = ProductFactory.createProduct("A");
            productA.create();

            Product productB = ProductFactory.createProduct("B");
            productB.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
