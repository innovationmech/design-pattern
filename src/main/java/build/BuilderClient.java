package build;

public class BuilderClient {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();

        Product product = builder.retrieveResult();
        System.out.println(product.getPart1() + " " + product.getPart2());
    }
}
