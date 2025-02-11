package callback.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTaskExecutor {

    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public CompletableFuture<String> executeTask(Task task) {
        return CompletableFuture.supplyAsync(() -> task.execute(), executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
