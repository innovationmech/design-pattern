package state;

import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        User user = new User();
        user.mockInterView();

        user.purchasePlus();
        user.mockInterView();

        user.expire();
        user.mockInterView();
    }
}
