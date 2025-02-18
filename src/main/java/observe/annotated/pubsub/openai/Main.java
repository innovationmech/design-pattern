package observe.annotated.pubsub.openai;

public class Main {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        ConcreteObserver observer = new ConcreteObserver();

        eventManager.registerObserver(observer);

        Event event = new Event("Hello, World!");
        eventManager.notifyObservers("eventType1", event);
    }
}
