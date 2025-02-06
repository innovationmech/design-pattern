package producerandconsumer.advanced.gemini;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AdvancedProducerConsumer pc = new AdvancedProducerConsumer(
                5, 50, 5, 10, Priority.MEDIUM, true
        );

        pc.start();

        Thread.sleep(30000);

        pc.stop();

        System.out.println("Producer-Consumer stopped.");
    }
}
