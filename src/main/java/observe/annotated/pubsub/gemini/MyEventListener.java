package observe.annotated.pubsub.gemini;

@EventListener
public class MyEventListener {

    @EventHandler(eventType = MyEvent.class)
    public void handleMyEvent(MyEvent event) {
        System.out.println("MyEventListener Received event on handleMyEvent: " + event.getMessage());
    }

    @EventHandler(eventType = Event.class)
    public void handleBaseEvent(Event event) {
        System.out.println("MyEventListener Received event on handleBaseEvent: " + event.getClass().getSimpleName());
    }
}
