package mediator.gemini;

// concrete colleague
public class ConcreteUser extends User {

    public ConcreteUser(String name, ChatRoom chatRoom) {
        super(name, chatRoom);
    }

    @Override
    public void sendMessage(String to, String message) {
        System.out.println(getName() + " is sending a message to " + to + ": " + message);
        chatRoom.sendMessage(getName(), to, message);
    }

    @Override
    public void receiveMessage(String from, String message) {

        System.out.println(getName() + " received a message from " + from + ": " + message);
    }
}
