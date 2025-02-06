package chain.qwen;

import java.util.Set;

public abstract class AbstractHandler implements Handler {

    protected Handler next;
    protected String name;

    public AbstractHandler(String name) {
        this.name = name;
    }

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean detectCycle(Set<String> visited) {
        if (visited.contains(this.name)) {
            return true;
        }
        visited.add(this.name);
        return next != null && next.detectCycle(visited);
    }
}
