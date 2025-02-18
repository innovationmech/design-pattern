package strategy.annotated;

public class OrderContext {

    private OrderStrategy orderStrategy;

    public OrderContext(String type) {
        orderStrategy = OrderStrategyFactory.getOrderStrategy(type);
    }

    public void process(Order order) {
        orderStrategy.processOrder(order);
    }
}
