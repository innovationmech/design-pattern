package strategy.annotated;

@OrderType("NORMAL")
public class NormalOrderStrategy implements OrderStrategy {
    @Override
    public void processOrder(Order order) {
        System.out.println("普通订单处理中...");
    }
}
