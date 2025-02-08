package state.table;

public class CompletedState implements OrderState {
    @Override
    public void handlePayment(OrderContextWithTable context) {
        System.out.println("订单已完成，无需支付。");
    }

    @Override
    public void handleShipping(OrderContextWithTable context) {
        System.out.println("订单已完成，无需发货。");
    }

    @Override
    public void handleCompletion(OrderContextWithTable context) {
        System.out.println("订单已完成，无需重复完成。");
    }

    @Override
    public String getStateDescription() {
        return "已完成";
    }
}
