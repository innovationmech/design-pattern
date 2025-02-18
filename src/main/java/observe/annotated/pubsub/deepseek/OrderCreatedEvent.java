package observe.annotated.pubsub.deepseek;

public class OrderCreatedEvent {

    private final String orderId;

    public OrderCreatedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
