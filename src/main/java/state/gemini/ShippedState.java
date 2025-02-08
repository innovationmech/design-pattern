package state.gemini;

public class ShippedState implements OrderState {
    @Override
    public void handlePayment(OrderContext context) {
        System.out.println("订单已发货，无需支付。");
    }

    @Override
    public void handleShipping(OrderContext context) {
        System.out.println("订单已发货，无需再次发货。");
    }

    @Override
    public void handleCompletion(OrderContext context) {
        System.out.println("订单已发货，正在完成订单...");
        // 实际完成订单逻辑...
        context.setState(new CompletedState()); // 状态转移到已完成
        System.out.println("订单已完成，状态更新为： " + context.getState().getStateDescription());
    }

    @Override
    public String getStateDescription() {
        return "已发货";
    }
}
