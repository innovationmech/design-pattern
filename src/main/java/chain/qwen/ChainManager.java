package chain.qwen;

import java.util.*;

public class ChainManager {

    private final Map<String, Handler> handlerMap = new HashMap<>();
    private Handler head;

    public void addHandler(Handler handler) {
        handlerMap.put(handler.getName(), handler);
        if (head == null) {
            head = handler;
        }
    }

    public void removeHandler(String name) {
        handlerMap.remove(name);
        if (head != null && head.getName().equals(name)) {
            head = null;
        }
    }

    public void modifyHandler(String name, Handler newHandler) {
        if (handlerMap.containsKey(name)) {
            handlerMap.put(name, newHandler);
        }
    }

    public void buildChain(List<String> handlerNames) {
        if (handlerNames.isEmpty()) {
            head = null;
            return;
        }

        for (Handler handler : handlerMap.values()) {
            handler.setNext(null);
        }

        Handler current = null;
        Set<String> visited = new HashSet<>();
        for (String name : handlerNames) {
            Handler handler = handlerMap.get(name);
            if (handler == null) {
                throw new IllegalArgumentException("Handler not found: " + name);
            }
            if (current == null) {
                head = handler;
            } else {
                current.setNext(handler);
            }
            current = handler;

            if (handler.detectCycle(new HashSet<>(visited))) {
                throw new IllegalArgumentException("Cycle detected in chain: " + name);
            }
            visited.add(handler.getName());
        }
    }

    public void processRequest(Request request) {
        if (head == null) {
            System.out.println("No handler available.");
            return;
        }
        head.handle(request);
    }


}
