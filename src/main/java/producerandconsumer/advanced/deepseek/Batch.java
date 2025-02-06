package producerandconsumer.advanced.deepseek;

import java.util.Collections;
import java.util.List;

public class Batch<T> implements Comparable<Batch<T>> {

    final List<T> items;
    final int priority;
    final long createAt = System.currentTimeMillis();

    public Batch(List<T> items, int priority) {
        this.items = Collections.unmodifiableList(items);
        this.priority = priority;
    }

    @Override
    public int compareTo(Batch<T> o) {
        int priorityCompare = Integer.compare(o.priority, this.priority);
        return priorityCompare == 0 ? Long.compare(this.createAt, o.createAt) : priorityCompare;
    }
}
