package state.table;

public class PaidState implements OrderState {
    @Override
    public void handlePayment(OrderContextWithTable context) {
        System.out.println("订单已支付，无需重复支付。");
    }

    @Override
    public void handleShipping(OrderContextWithTable context) {
        System.out.println("订单已支付，正在准备发货...");
        System.out.println("发货操作..."); // 模拟发货操作
        context.changeState(OrderEvent.SHIPPING_PROCESSED); // 触发状态转移事件
    }

    @Override
    public void handleCompletion(OrderContextWithTable context) {
        System.out.println("订单已支付，但未发货，无法完成。");
    }

    @Override
    public String getStateDescription() {
        return "已支付";
    }
}
