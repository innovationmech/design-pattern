package state.gemini;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new PendingPaymentState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    public void processPayment() {
        state.handlePayment(this);
    }

    public void processShipping() {
        state.handleShipping(this);
    }

    public void completeOrder() {
        state.handleCompletion(this);
    }
}
