package observe.annotated.pubsub.openai;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private final Map<String, List<Method>> observers = new HashMap<>();

    public void registerObserver(Object observer) {
        Class<?> observerClass = observer.getClass();
        if (observerClass.isAnnotationPresent(Observer.class)) {
            String observerName = observerClass.getAnnotation(Observer.class).value();
            for (Method method : observerClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventHandler.class)) {
                    observers.computeIfAbsent(observerName, k -> new ArrayList<>()).add(method);
                }
            }
        }
    }

    public void notifyObservers(String eventType, Event event) {
        List<Method> methods = observers.get(eventType);
        if (methods != null) {
            for (Method method : methods) {
                try {
                    method.setAccessible(true);
                    method.invoke(method.getDeclaringClass().newInstance(), event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
