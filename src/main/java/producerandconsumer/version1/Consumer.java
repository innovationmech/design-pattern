package producerandconsumer.version1;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Start consumer id: " + Thread.currentThread().getId());
        Random r= new Random();
        try {
            do
            {
                PCData data = queue.take();
                int re = data.getIntData() * data.getIntData();
                System.out.println(MessageFormat.format("{0} * {1} = {2}", data.getIntData(), data.getIntData(),
                    re));
                Thread.sleep(r.nextInt(SLEEPTIME));
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
