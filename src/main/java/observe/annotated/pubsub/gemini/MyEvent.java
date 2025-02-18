package observe.annotated.pubsub.gemini;

public class MyEvent extends Event {

    private String message;

    public MyEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
