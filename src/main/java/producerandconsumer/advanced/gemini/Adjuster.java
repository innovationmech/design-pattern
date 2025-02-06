package producerandconsumer.advanced.gemini;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Adjuster implements Runnable {
    private final long checkInterval;
    private int lastQueueSize = 0;
    private final BlockingQueue<Task> queue;
    private final AtomicInteger consumerCount;
    private ExecutorService consumerExecutor;
    private final int maxConsumer;
    private final AdvancedProducerConsumer.ProducerLockWrapper producerLockWrapper;

    public Adjuster(long checkInterval, BlockingQueue<Task> queue, AtomicInteger consumerCount, ExecutorService consumerExecutor, int maxConsumer, AdvancedProducerConsumer.ProducerLockWrapper producerLockWrapper) {
        this.checkInterval = checkInterval;
        this.queue = queue;
        this.consumerCount = consumerCount;
        this.consumerExecutor = consumerExecutor;
        this.maxConsumer = maxConsumer;
        this.producerLockWrapper = producerLockWrapper;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(checkInterval);
                int currentQueueSize = queue.size();
                double changeRate = (double) (currentQueueSize - lastQueueSize) / checkInterval;

                if (currentQueueSize > queue.size() * 0.8) {
                    if (consumerCount.get() < maxConsumer) {
                        consumerExecutor.execute(new Consumer(consumerCount.getAndIncrement(), queue, 10));
                        System.out.println("Adjuster: Added a new consumer. Total consumers: " + consumerCount.get());
                    }
                    producerLockWrapper.setBackPressure(true);
                    System.out.println("Back pressure activated!");
                } else if (changeRate < -0.5) {
                    if (consumerCount.get() > 1) {
                        consumerExecutor.shutdownNow();
                        consumerCount.decrementAndGet();
                        System.out.println("Adjuster: Removed a consumer. Total consumers: " + consumerCount.get());

                        consumerExecutor = Executors.newFixedThreadPool(maxConsumer);

                        for (int i = 0; i < consumerCount.get(); i++) {
                            consumerExecutor.execute(new Consumer(i, queue, 10));
                        }
                    }

                    if (currentQueueSize < queue.size() * 0.2) {
                        producerLockWrapper.setBackPressure(false);
                        producerLockWrapper.signalAll();
                        System.out.println("Back pressure released!");
                    }
                }
                lastQueueSize = currentQueueSize;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}