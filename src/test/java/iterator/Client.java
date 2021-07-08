package iterator;

import iterator.pratice2.GroceryList;
import org.junit.Test;

public class Client
{
    @Test
    public void test01() {
        MyList list = new MyList();

        for (String item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void test02() {
        GroceryList list = new GroceryList();

        for (String good : list) {
            System.out.println(good);
        }
    }
}
