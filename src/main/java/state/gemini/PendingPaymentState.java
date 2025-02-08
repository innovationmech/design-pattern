package state.gemini;

public class PendingPaymentState implements OrderState {
    @Override
    public void handlePayment(OrderContext context) {
        System.out.println("订单待支付，正在处理支付...");
        // 实际支付逻辑...
        context.setState(new ShippedState());
        System.out.println("支付完成，订单状态更新为： " + context.getState().getStateDescription());
    }

    @Override
    public void handleShipping(OrderContext context) {
        System.out.println("订单待支付，无法发货。");
    }

    @Override
    public void handleCompletion(OrderContext context) {
        System.out.println("订单待支付，无法完成。");
    }

    @Override
    public String getStateDescription() {
        return "待支付";
    }
}
