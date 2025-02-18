package observe.annotated.pubsub.deepseek;

public class OrderObserver {

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("处理订单创建事件，订单ID: " + event.getOrderId());
    }

    @EventListener
    private void logOrderCreated(OrderCreatedEvent event) {
        System.out.println("[日志记录] 订单已创建: " + event.getOrderId());
    }
}
