package callback.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        CompletableFutureTaskExecutor executor = new CompletableFutureTaskExecutor();
        Task task = new Task("Download file");

        CompletableFuture<String> future = executor.executeTask(task);
        future.thenAccept(result -> System.out.println("Callback received: " + result));
        future.exceptionally(ex -> {
            System.out.println("Error occurred: " + ex.getMessage());
            return null;
        });
        System.out.println("Main thread continues to run.");
        executor.shutdown();
    }
}
