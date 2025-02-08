package state.gemini;

public class CompletedState implements OrderState {
    @Override
    public void handlePayment(OrderContext context) {
        System.out.println("订单已完成，无需支付。");
    }

    @Override
    public void handleShipping(OrderContext context) {
        System.out.println("订单已完成，无需发货。");
    }

    @Override
    public void handleCompletion(OrderContext context) {
        System.out.println("订单已完成，无需重复完成。");
    }

    @Override
    public String getStateDescription() {
        return "已完成";
    }
}
