package observe.annotated.pubsub.deepseek;

public class Main {

    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();

        publisher.register(new OrderObserver());
        publisher.register(new EmailNotifier());

        publisher.publishEvent(new OrderCreatedEvent("123456"));
    }
}
