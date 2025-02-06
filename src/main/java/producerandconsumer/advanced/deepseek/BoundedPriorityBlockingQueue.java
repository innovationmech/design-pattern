package producerandconsumer.advanced.deepseek;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedPriorityBlockingQueue<T> {

    private final PriorityQueue<Batch<T>> queue;
    private final int capacity;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public BoundedPriorityBlockingQueue(int capacity, boolean fair) {
        this.capacity = capacity;
        this.queue = new PriorityQueue<>();
        this.lock = new ReentrantLock(fair);
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(Batch<T> batch) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                notFull.await();
            }
            queue.add(batch);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Batch<T> take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            Batch<T> batch = queue.poll();
            notFull.signalAll();
            return batch;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public int remainingCapacity() {
        lock.lock();
        try {
            return capacity - queue.size();
        } finally {
            lock.unlock();
        }
    }
}
