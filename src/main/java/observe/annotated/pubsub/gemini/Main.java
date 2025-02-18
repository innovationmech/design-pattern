package observe.annotated.pubsub.gemini;

public class Main {

    public static void main(String[] args) {
        EventPublisher eventPublisher = EventPublisher.getInstance();

        eventPublisher.registerListeners("observe.annotated.pubsub.gemini");

        eventPublisher.publishEvent(new MyEvent("Hello, World!"));
        eventPublisher.publishEvent(new Event());
    }
}
