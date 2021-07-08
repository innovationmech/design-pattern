package iterator.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PracticeList implements Iterable<String>
{
    private List<String> data = Arrays.asList("a", "b", "c");

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        private int index;
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
