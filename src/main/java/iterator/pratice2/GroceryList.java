package iterator.pratice2;

import java.util.Iterator;

public class GroceryList implements Iterable<String>
{
    private final String[] goods = new String[]{"apple", "banana", "orange"};

    @Override
    public Iterator<String> iterator()
    {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        int index = 0;

        @Override
        public boolean hasNext()
        {
            return index < goods.length;
        }

        @Override
        public String next()
        {
            return goods[index++];
        }
    }
}
