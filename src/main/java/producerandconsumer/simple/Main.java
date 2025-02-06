package producerandconsumer.simple;

public class Main {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue(10);
        Thread producer = new Thread(new Producer(sharedQueue));
        Thread consumer = new Thread(new Consumer(sharedQueue));

        producer.start();
        consumer.start();
    }
}
