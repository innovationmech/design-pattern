package observe.annotated.pubsub.gemini;

@EventListener
public class AnotherEventListener {

    @EventHandler(eventType = MyEvent.class)
    public void onMyEvent(MyEvent event) {
        System.out.println("AnotherEventListener received MyEvent: " + event.getMessage());
    }
}
