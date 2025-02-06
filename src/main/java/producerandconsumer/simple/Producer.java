package producerandconsumer.simple;

public class Producer implements Runnable {

    private final SharedQueue sharedQueue;

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int value = (int) (Math.random() * 100);
                sharedQueue.produce(value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
