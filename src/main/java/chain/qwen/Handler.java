package chain.qwen;

import java.util.Set;

public interface Handler {

    void setNext(Handler next);
    void handle(Request request);
    String getName();
    boolean detectCycle(Set<String> visited);
}
