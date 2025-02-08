package mediator.gemini;

public class Main {


    public static void main(String[] args) {
        ChatRoom chatRoom = new ConcreteChatRoom();
        User user1 = new ConcreteUser("Tom", chatRoom);
        User user2 = new ConcreteUser("Jerry", chatRoom);
        User user3 = new ConcreteUser("Mike", chatRoom);

        chatRoom.register("Tom", user1);
        chatRoom.register("Jerry", user2);
        chatRoom.register("Mike", user3);

        user1.sendMessage("Jerry", "Hello, Jerry!");
        user2.sendMessage("Tom", "Hello, Tom!");
        user3.sendMessage("Jerry", "Hello, Jerry!");
    }


}
