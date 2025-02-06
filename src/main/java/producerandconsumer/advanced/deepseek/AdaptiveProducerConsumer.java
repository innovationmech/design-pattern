package producerandconsumer.advanced.deepseek;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.*;

public class AdaptiveProducerConsumer<T> implements ProducerConsumerContext<T> {

    private final BoundedPriorityBlockingQueue<T> queue;
    private final ThreadPoolExecutor producers;
    private final ThreadPoolExecutor consumers;
    private volatile boolean running = true;
    private final int maxBatchSize;
    private final int backpressureThreshold;

    public AdaptiveProducerConsumer(int queueCapacity, int maxProducer, int maxConsumer, int maxBatchSize, boolean fairLock) {
        this.queue = new BoundedPriorityBlockingQueue<>(queueCapacity, fairLock);
        this.maxBatchSize = maxBatchSize;
        this.backpressureThreshold = (int) (queueCapacity * 0.8);

        this.producers = new ThreadPoolExecutor(1, maxConsumer, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactory() {
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "producer-" + count++);
                    }
                });

        this.consumers = new ThreadPoolExecutor(1, maxConsumer, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactory() {
                    private int count = 0;
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "consumer-" + count++);
                    }
                });

        startMonitorThread();
    }

    @Override
    public BoundedPriorityBlockingQueue<T> getQueue() {
        return queue;
    }

    @Override
    public int calculatePriority(List<T> batch) {
        return 0;
    }

    @Override
    public int getMaxBatchSize() {
        return maxBatchSize;
    }

    @Override
    public int getBackpressureThreshold() {
        return backpressureThreshold;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public void start(int initialProducers, int initialConsumers) {
        adjustProducers(initialProducers);
        adjustConsumers(initialConsumers);
    }

    public void adjustProducers(int target) {
        int current = producers.getPoolSize();
        if (target > current) {
            for (int i = current; i < target; i++) {
                producers.execute(new Producer<>(this));
            }
        }
    }

    public void adjustConsumers(int target) {
        int current = consumers.getPoolSize();
        if (target > current) {
            for (int i = current; i < target; i++) {
                consumers.execute(new Consumer<>(this));
            }
        }
    }

    private void startMonitorThread() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            try {
                int queueSize = queue.size();
                int cpuLoad = getSystemLoad();

                int targetProducers = calculateOptimalProducers(queueSize, cpuLoad);
                int targetConsumers = calculateOptimalConsumers(queueSize, cpuLoad);

                adjustProducers(targetProducers);
                adjustConsumers(targetConsumers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

    private int getSystemLoad() {
        return (int) (ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage() + 10);
    }

    private int calculateOptimalProducers(int queueSize, int systemLoad) {
        if (systemLoad > 70) {
            return 1;
        }
        if (queueSize < backpressureThreshold) {
            return producers.getMaximumPoolSize();
        }
        return Math.max(1, producers.getPoolSize() - 1);
    }

    private int calculateOptimalConsumers(int queueSize, int systemLoad) {
        if (systemLoad > 70) {
            return 1;
        }
        if (queueSize > backpressureThreshold) {
            return Math.max(1, consumers.getPoolSize() - 1);
        }
        return consumers.getMaximumPoolSize();
    }

    public void shutDown() {
        running = false;
        producers.shutdownNow();
        consumers.shutdownNow();
    }
}