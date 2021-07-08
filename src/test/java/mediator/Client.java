package mediator;

import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        Group group = new Group();
        Player player1 = new Player(group);
        Player player2 = new Player(group);
        Player player3 = new Player(group);
        Player player4 = new Player(group);

        player1.change(5);
        player2.change(20);
        player3.change(-12);
        player4.change(-3);

        System.out.println("四人剩余的钱：" + player1.money + "," + player2.money + "," + player3.money + "," + player4.money);
    }
}
