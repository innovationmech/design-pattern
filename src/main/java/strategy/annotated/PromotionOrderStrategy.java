package strategy.annotated;

@OrderType("PROMOTION")
public class PromotionOrderStrategy implements OrderStrategy {


    @Override
    public void processOrder(Order order) {
        System.out.println("促销订单处理中...");
    }
}
