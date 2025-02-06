package producerandconsumer.advanced.deepseek;

import java.util.List;

public interface ProducerConsumerContext<T> {
    BoundedPriorityBlockingQueue<T> getQueue();
    int calculatePriority(List<T> batch);
    int getMaxBatchSize();
    int getBackpressureThreshold();
    boolean isRunning();
}