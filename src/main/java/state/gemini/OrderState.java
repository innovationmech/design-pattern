package state.gemini;

public interface OrderState {

    void handlePayment(OrderContext context);

    void handleShipping(OrderContext context);

    void handleCompletion(OrderContext context);

    String getStateDescription();
}
