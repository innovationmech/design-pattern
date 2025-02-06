package producerandconsumer.advanced.gemini;

public class Task implements Comparable<Task> {
    final int priority;
    final int data;

    Task(int priority, int data) {
        this.priority = priority;
        this.data = data;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(o.priority, this.priority);
    }
}