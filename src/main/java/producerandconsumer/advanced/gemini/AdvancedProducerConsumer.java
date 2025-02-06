package producerandconsumer.advanced.gemini;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdvancedProducerConsumer {

    private final int batchSize;
    private final int bufferCapacity;
    private final BlockingQueue<Task> queue;
    private final ExecutorService producerExecutor;
    private ExecutorService consumerExecutor;
    private final AtomicInteger producerCount = new AtomicInteger(1);
    private final AtomicInteger consumerCount = new AtomicInteger(1);
    private final ProducerLockWrapper producerLockWrapper;
    private volatile boolean backPressure = false;
    private final Priority priority;
    private final Thread adjusterThread;
    private final int maxProducer;
    private final int maxConsumer;

    class ProducerLockWrapper {
        private final ReentrantLock lock;
        private final Condition condition;

        ProducerLockWrapper(boolean fair) {
            this.lock = new ReentrantLock(fair);
            this.condition = lock.newCondition();
        }

        void lock() {
            lock.lock();
        }

        void unlock() {
            lock.unlock();
        }

        void await() throws InterruptedException {
            condition.await();
        }

        void signalAll() {
            condition.signalAll();
        }

        boolean isBackPressure() {
            return backPressure;
        }

        void setBackPressure(boolean backPressure) {
            AdvancedProducerConsumer.this.backPressure = backPressure;
        }
    }

    public AdvancedProducerConsumer(int batchSize, int bufferCapacity, int maxProducer, int maxConsumer, Priority priority, boolean fairLock) {
        this.batchSize = batchSize;
        this.bufferCapacity = bufferCapacity;
        this.queue = new PriorityBlockingQueue<>(bufferCapacity);
        this.producerExecutor = Executors.newFixedThreadPool(maxProducer);
        this.consumerExecutor = Executors.newFixedThreadPool(maxConsumer);
        this.producerLockWrapper = new ProducerLockWrapper(fairLock);
        this.priority = priority;
        this.maxProducer = maxProducer;
        this.maxConsumer = maxConsumer;

        this.adjusterThread = new Thread(new Adjuster(2000, queue, consumerCount, consumerExecutor, maxConsumer, producerLockWrapper));
        this.adjusterThread.start();
    }

    public void start() {
        for (int i = 0; i < producerCount.get(); i++) {
            producerExecutor.execute(new Producer(i, queue, producerLockWrapper, priority, batchSize));
        }
        for (int i = 0; i < consumerCount.get(); i++) {
            consumerExecutor.execute(new Consumer(i, queue, batchSize));
        }
    }

    public void stop() {
        producerExecutor.shutdownNow();
        consumerExecutor.shutdownNow();
        adjusterThread.interrupt();
        try {
            adjusterThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}