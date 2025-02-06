package producerandconsumer.advanced.gemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final Random random = new Random();
    private final int id;
    private final BlockingQueue<Task> queue;
    private final AdvancedProducerConsumer.ProducerLockWrapper producerLockWrapper;
    private final Priority priority;
    private final int batchSize;

    public Producer(int id, BlockingQueue<Task> queue,
                    AdvancedProducerConsumer.ProducerLockWrapper producerLockWrapper,
                    Priority priority, int batchSize) {
        this.id = id;
        this.queue = queue;
        this.producerLockWrapper = producerLockWrapper;
        this.priority = priority;
        this.batchSize = batchSize;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                producerLockWrapper.lock();
                try {
                    while (producerLockWrapper.isBackPressure()) {
                        System.out.println("producer " + id + ": Back pressure, waiting...");
                        producerLockWrapper.await();
                    }
                } finally {
                    producerLockWrapper.unlock();
                }

                List<Task> tasks = new ArrayList<>();
                for (int i = 0; i < batchSize; i++) {
                    int priorityValue;
                    switch (priority) {
                        case HIGH:
                            priorityValue = random.nextInt(3) + 8;
                            break;
                        case MEDIUM:
                            priorityValue = random.nextInt(4) + 4;
                            break;
                        case LOG:
                        default:
                            priorityValue = random.nextInt(4);
                            break;
                    }
                    tasks.add(new Task(priorityValue, random.nextInt(100)));
                }
                for (Task task : tasks) {
                    queue.put(task);
                }
                System.out.println("producer " + id + ": Produced " + tasks.size() + " tasks");
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("producer " + id + ": Interrupted");
        }
    }
}