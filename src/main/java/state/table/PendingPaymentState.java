package state.table;

public class PendingPaymentState implements OrderState {
    @Override
    public void handlePayment(OrderContextWithTable context) {
        System.out.println("订单待支付，正在尝试处理支付...");
        //  支付的具体逻辑可以放在 Context 或者单独的服务中
        System.out.println("支付操作..."); // 模拟支付操作
        context.changeState(OrderEvent.PAYMENT_PROCESSED);
    }

    @Override
    public void handleShipping(OrderContextWithTable context) {
        System.out.println("订单待支付，无法发货。");
    }

    @Override
    public void handleCompletion(OrderContextWithTable context) {
        System.out.println("订单待支付，无法完成。");
    }

    @Override
    public String getStateDescription() {
        return "待支付";
    }
}
