package mediator.gemini;

// Mediator interface
public interface ChatRoom {
    void register(String name, User user);
    void sendMessage(String from, String to, String message);
}
