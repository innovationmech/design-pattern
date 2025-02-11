package callback.gemini;

public class TaskExecutor {

    public void executeTask(Task task, Callback callback) {
        new Thread(() -> {
            String result = task.execute();
            callback.onComplete(result);
        }).start();
    }
}
