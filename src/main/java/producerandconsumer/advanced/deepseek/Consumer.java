package producerandconsumer.advanced.deepseek;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer<T> implements Runnable {

    private final ProducerConsumerContext<T> context;
    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    public Consumer(ProducerConsumerContext<T> context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (context.isRunning() && !Thread.currentThread().isInterrupted()) {
            try {
                Batch<T> batch = context.getQueue().take();
                processBatch(batch);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                handleConsumerError(e);
            }
        }
    }

    private void processBatch(Batch<T> batch) {
        try {
            Thread.sleep(batch.items.size() * 10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 新增: 处理消费者错误的方法
    private void handleConsumerError(Throwable t) {
        logger.log(Level.SEVERE, "Consumer error occurred", t);
        // 可以在这里添加其他处理逻辑，例如重试机制或通知其他组件
    }
}