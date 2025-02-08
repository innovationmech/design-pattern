package mediator.gemini;

import java.util.HashMap;
import java.util.Map;

// concrete mediator
public class ConcreteChatRoom implements ChatRoom {

    private Map<String, User> users = new HashMap<>();

    @Override
    public void register(String name, User user) {
        users.put(name, user);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        if (users.containsKey(from) && users.containsKey(to)) {
            User receiver = users.get(to);
            receiver.receiveMessage(from, message);
        } else {
            System.out.println("User " + from + " or " + to + " not found.");
        }
    }
}
