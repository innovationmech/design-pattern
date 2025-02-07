package strategy.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentStrategyFactory {

    private static final Map<PaymentStrategyType, PaymentStrategy> strategyCache = new ConcurrentHashMap<>();

    public static PaymentStrategy getPaymentStrategy(PaymentStrategyType type) {
        if (strategyCache.containsKey(type)) {
            return strategyCache.get(type);
        }

        PaymentStrategy strategy = type.createStrategy();
        strategyCache.put(type, strategy);
        return strategy;
    }
}
