package strategy.composite;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyFactory {

    private static final Map<PaymentStrategyType, Strategy> strategyCache = new ConcurrentHashMap<>();

    public static Strategy getStrategy(PaymentStrategyType type, Object... params) {
        if (strategyCache.containsKey(type)) {
            return strategyCache.get(type);
        }

        Strategy strategy = type.createStrategy(params);
        strategyCache.put(type, strategy);
        return strategy;
    }
}
