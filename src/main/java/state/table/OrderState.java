package state.table;

public interface OrderState {
    void handlePayment(OrderContextWithTable context);
    void handleShipping(OrderContextWithTable context);
    void handleCompletion(OrderContextWithTable context);
    String getStateDescription();
}
