package observe.annotated.pubsub.deepseek;

public class EmailNotifier {

    @EventListener
    public void sendNotification(OrderCreatedEvent event) {
        System.out.println("发送邮件通知，订单号: " + event.getOrderId());
    }
}
