package producerandconsumer.optimized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OptimizedStorage {

    private final Object[] items;
    private int putIndex, takeIndex, count;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public OptimizedStorage(int capacity) {
        items = new Object[capacity];
    }

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex] = x;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeIndex];
            if (++takeIndex == items.length) {
                takeIndex = 0;
            }
            --count;
            notFull.signalAll();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
