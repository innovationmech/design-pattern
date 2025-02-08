package state.table;

public class ShippedState implements OrderState {
    @Override
    public void handlePayment(OrderContextWithTable context) {
        System.out.println("订单已发货，无需支付。");
    }

    @Override
    public void handleShipping(OrderContextWithTable context) {
        System.out.println("订单已发货，无需再次发货。");
    }

    @Override
    public void handleCompletion(OrderContextWithTable context) {
        System.out.println("订单已发货，正在完成订单...");
        System.out.println("完成订单操作..."); // 模拟完成订单操作
        context.changeState(OrderEvent.ORDER_COMPLETED); // 触发状态转移事件
    }

    @Override
    public String getStateDescription() {
        return "已发货";
    }
}
