package state.gemini;

public class PaidState implements OrderState {
    @Override
    public void handlePayment(OrderContext context) {
        System.out.println("订单已支付，无需重复支付。");
    }

    @Override
    public void handleShipping(OrderContext context) {
        System.out.println("订单已支付，正在准备发货...");
        // 实际发货逻辑...
        context.setState(new ShippedState()); // 状态转移到已发货
        System.out.println("已发货，订单状态更新为： " + context.getState().getStateDescription());
    }

    @Override
    public void handleCompletion(OrderContext context) {
        System.out.println("订单已支付，但未发货，无法完成。");
    }

    @Override
    public String getStateDescription() {
        return "已支付";
    }
}
