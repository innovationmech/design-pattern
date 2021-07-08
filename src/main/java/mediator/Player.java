package mediator;

public class Player
{
    public int money = 100;
    public Group group;

    public Player(Group group) {
        this.group = group;
    }

    public void change(int money) {
        group.money += money;
        this.money += money;
    }
}
