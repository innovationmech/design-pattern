package producerandconsumer.advanced.gemini;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final Random random = new Random();
    private final int id;
    private final BlockingQueue<Task> queue;
    private final int batchSize;

    public Consumer(int id, BlockingQueue<Task> queue, int batchSize) {
        this.id = id;
        this.queue = queue;
        this.batchSize = batchSize;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                List<Task> tasks = new ArrayList<>();
                queue.drainTo(tasks, batchSize);
                if (!tasks.isEmpty()) {
                    System.out.println("consumer " + id + ": Consumed " + tasks.size() + " tasks");
                    for (Task task : tasks) {
                        Thread.sleep(random.nextInt(1000));
                        System.out.println("Consumer " + id + ": Processing task with priority " + task.priority + " and data " + task.data);
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("consumer " + id + ": Interrupted");
        }
    }
}