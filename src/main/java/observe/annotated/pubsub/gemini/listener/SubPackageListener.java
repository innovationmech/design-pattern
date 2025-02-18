package observe.annotated.pubsub.gemini.listener;

import observe.annotated.pubsub.gemini.EventHandler;
import observe.annotated.pubsub.gemini.EventListener;
import observe.annotated.pubsub.gemini.MyEvent;

@EventListener
public class SubPackageListener {

    @EventHandler(eventType = MyEvent.class)
    public void onMyEvent(MyEvent event) {
        System.out.println("SubPackageListener: " + event.getMessage());
    }
}
