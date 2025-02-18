package observe.annotated.pubsub.openai;

@Observer("eventType1")
public class ConcreteObserver {

    @EventHandler
    public void handlerEvent(Event event) {
        System.out.println("Received event: " + event.getMessage());
    }
}
