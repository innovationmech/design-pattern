package observe.annotated.pubsub.deepseek;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventPublisher {

    private final Map<Class<?>, List<Subscriber>> subscribers = new ConcurrentHashMap<>();

    private static class Subscriber {
        private final Object target;
        private final Method method;

        Subscriber(Object target, Method method) {
            this.target = target;
            this.method = method;
            this.method.setAccessible(true);
        }

        void handlerEvent(Object event) {
            try {
                method.invoke(target, event);
            } catch (Exception e) {
                throw new RuntimeException("事件处理失败");
            }
        }
    }

    public void register(Object observer) {
        for (Method method : observer.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventListener.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("EventListener方法必须有且只有一个参数");
                }

                Class<?> eventType = parameterTypes[0];
                subscribers.computeIfAbsent(eventType, k -> new ArrayList<>())
                        .add(new Subscriber(observer, method));
            }
        }
    }

    public void publishEvent(Object event) {
        List<Subscriber> eventSubscribers = subscribers.get(event.getClass());
        if (eventSubscribers != null) {
            for (Subscriber subscriber : eventSubscribers) {
                subscriber.handlerEvent(event);
            }
        }
    }
}
