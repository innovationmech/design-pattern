package observe.annotated.pubsub.openai;

public class Event {

    private String message;

    public Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
