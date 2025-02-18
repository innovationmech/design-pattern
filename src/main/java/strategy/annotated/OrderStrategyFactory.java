package strategy.annotated;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OrderStrategyFactory {

    private static final Map<String, OrderStrategy> STRATEGY_MAP = new ConcurrentHashMap<>();

    static {
        Reflections reflections = new Reflections("strategy.annotated");
        Set<Class<?>> strategyClasses = reflections.getTypesAnnotatedWith(OrderType.class);
        for (Class<?> strategyClass : strategyClasses) {
            OrderType orderType = strategyClass.getAnnotation(OrderType.class);
            String strategyType = orderType.value();
            try {
                OrderStrategy strategy = (OrderStrategy) strategyClass.newInstance();
                STRATEGY_MAP.put(strategyType, strategy);

            } catch (Exception e) {
                throw new RuntimeException("Failed to create strategy: " + strategyType, e);
            }
        }
    }

    public static OrderStrategy getOrderStrategy(String type) {
        return STRATEGY_MAP.get(type);
    }
}
