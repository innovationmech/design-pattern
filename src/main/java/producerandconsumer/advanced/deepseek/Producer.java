package producerandconsumer.advanced.deepseek;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer<T> implements Runnable {

    private final ProducerConsumerContext<T> context;
    private static final Logger logger = Logger.getLogger(Producer.class.getName());

    public Producer(ProducerConsumerContext<T> context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (context.isRunning() && !Thread.currentThread().isInterrupted()) {
            try {
                int currentBatchSize = calculateBatchSize();
                List<T> batch = produceBatch(currentBatchSize);

                if (!batch.isEmpty()) {
                    int priority = context.calculatePriority(batch);
                    context.getQueue().put(new Batch<>(batch, priority));
                }
                Thread.sleep(calculateSleepTime());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                handleProducerError(e);
            }
        }
    }

    private int calculateBatchSize() {
        int remaining = context.getQueue().remainingCapacity();
        if (remaining < 1) {
            return 0;
        }
        return Math.min(context.getMaxBatchSize(), remaining);
    }

    private List<T> produceBatch(int batchSize) {
        List<T> batch = new ArrayList<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            try {
                batch.add(generateItem());
            } catch (Exception e) {
                handleItemGenerationError(e);
            }
        }
        return batch;
    }

    private long calculateSleepTime() {
        int size = context.getQueue().size();
        if (size < context.getBackpressureThreshold()) {
            return 100L * (size - context.getBackpressureThreshold());
        }
        return 50;
    }

    // 新增: 本地生成Item的逻辑
    private T generateItem() {
        // 这里添加具体的生成Item的逻辑
        return null;
    }

    // 新增: 处理生产者错误的方法
    private void handleProducerError(Throwable t) {
        logger.log(Level.SEVERE, "Producer error occurred", t);
        // 可以在这里添加其他处理逻辑，例如重试机制或通知其他组件
    }

    // 新增: 处理Item生成错误的方法
    private void handleItemGenerationError(Throwable t) {
        logger.log(Level.SEVERE, "Item generation error occurred", t);
        // 可以在这里添加其他处理逻辑，例如重试机制或通知其他组件
    }
}