package observe.annotated.pubsub.gemini;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class EventPublisher {

    private static volatile EventPublisher instance;
    private List<Object> listeners = new ArrayList<>();
    private Map<Object, List<Method>> listenerMethodCache = new ConcurrentHashMap<>();

    private EventPublisher() {}

    public static EventPublisher getInstance() {
        if (instance == null) {
            synchronized (EventPublisher.class) {
                if (instance == null) {
                    instance = new EventPublisher();
                }
            }
        }
        return instance;
    }

    public void registerListeners(String packageName) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(packageName))
                .setScanners(new TypeAnnotationsScanner(), new MethodAnnotationsScanner(), new SubTypesScanner()));

        Set<Class<?>> listenerClasses = reflections.getTypesAnnotatedWith(EventListener.class);

        for (Class<?> listenerClass : listenerClasses) {
            try {
                Object listenerInstance = listenerClass.getDeclaredConstructor().newInstance();
                listeners.add(listenerInstance);

                List<Method> cachedMethods = new ArrayList<>();
                Method[] methods = listenerClass.getDeclaredMethods();
                for (Method method : methods) {
                    EventHandler eventHandler = method.getAnnotation(EventHandler.class);
                    if (eventHandler != null) {
                        cachedMethods.add(method);
                    }
                }
                listenerMethodCache.put(listenerInstance, cachedMethods);

            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                System.err.println("Failed to register listener: " + listenerClass.getName() + ", error: " + e.getMessage());
            }
        }
    }

    public void publishEvent(Event event) {
        for (Object listener : listeners) {
            List<Method> cachedMethods = listenerMethodCache.get(listener);
            if (cachedMethods != null) {
                for (Method method : cachedMethods) {
                    EventHandler eventHandler = method.getAnnotation(EventHandler.class);
                    if (eventHandler.eventType().isAssignableFrom(event.getClass())) {
                        try {
                            method.invoke(listener, event);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            System.err.println("Error invoking event handler: " + method.getName() + " in listener: " + listener.getClass().getName() + ", error: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
