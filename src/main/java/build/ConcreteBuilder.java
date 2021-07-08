package build;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPart1() {
        System.out.println("构建第一个零件");
        product.setPart1("id: 123");
    }

    @Override
    public void buildPart2() {
        System.out.println("构建第二个零件");
        product.setPart2("名称：变形金刚");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
