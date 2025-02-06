package producerandconsumer.simple;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(value);
        System.out.println(Thread.currentThread().getName() + " produce " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consume " + value);
        notifyAll();
        return value;
    }
}
