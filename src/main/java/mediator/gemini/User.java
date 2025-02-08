package mediator.gemini;

// abstract colleague
public abstract class User {

    protected String name;
    protected ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public abstract void sendMessage(String to, String message);
    public abstract void receiveMessage(String from, String message);
}
