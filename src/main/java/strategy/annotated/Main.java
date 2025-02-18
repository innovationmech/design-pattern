package strategy.annotated;

public class Main {

    public static void main(String[] args) {
        Order order = new Order("1", "NORMAL");
        OrderContext context = new OrderContext("NORMAL");
        context.process(order);
    }
}
