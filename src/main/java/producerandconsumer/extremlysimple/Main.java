package producerandconsumer.extremlysimple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        // buffer
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        // producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    queue.put(i++);
                    System.out.println("put " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        // consumer
        new Thread(() -> {
            while (true) {
                try {
                    Integer value = queue.take();
                    System.out.println("take " + value);
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
