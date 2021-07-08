package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyList implements Iterable<String>
{
    private List<String> data = Arrays.asList("a", "b", "c");

    @Override
    public Iterator<String> iterator()
    {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext()
        {
            return index < data.size();
        }

        @Override
        public String next()
        {
            return data.get(index++);
        }
    }
}
