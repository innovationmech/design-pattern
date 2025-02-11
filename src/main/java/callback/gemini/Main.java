package callback.gemini;

public class Main {

    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutor();
        Task task = new Task("Download file");

        Callback callback = result -> System.out.println("Callback received: " + result);

        executor.executeTask(task, callback);

        System.out.println("Main thread continues to run.");
    }
}
