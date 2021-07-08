package memento;

import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        Player player = new Player();

        Memento memento = player.saveState();

        player.fightBoss();

        player.restoreState(memento);
    }
}
