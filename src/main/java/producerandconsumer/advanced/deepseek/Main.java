package producerandconsumer.advanced.deepseek;

public class Main {

    public static void main(String[] args) {
        AdaptiveProducerConsumer<String> pc = new AdaptiveProducerConsumer<>(100, 5, 5, 10, true);

        pc.start(2, 3);

        Runtime.getRuntime().addShutdownHook(new Thread(pc::shutDown));
    }
}
