package producerandconsumer.simple;

public class Consumer implements Runnable {

    private final SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                sharedQueue.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
