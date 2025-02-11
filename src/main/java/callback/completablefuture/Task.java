package callback.completablefuture;

public class Task {

    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String execute() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task '" + taskName + "' completed";
    }
}
