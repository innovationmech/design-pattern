package strategy.composite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectStrategyFactory {

    private static final Properties properties = new Properties();
    private static final Map<String, Strategy> strategyCache = new ConcurrentHashMap<>();

    static {
        try {
            properties.load(new FileInputStream("strategy.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Strategy getStrategy(String strategyName, Object... params) {
        if (strategyCache.containsKey(strategyName)) {
            return strategyCache.get(strategyName);
        }
        String className = properties.getProperty(strategyName);
        if (className == null) {
            throw new IllegalArgumentException("Invalid strategy name: " + strategyName);
        }
        try {
            Class<?> clazz = Class.forName(className);
            Strategy strategy = (Strategy) clazz.getConstructor(getParameterClasses(params)).newInstance(params);
            strategyCache.put(strategyName, strategy);
            return strategy;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create strategy: " + strategyName, e);
        }
    }

    private static Class<?>[] getParameterClasses(Object... params) {
        if (params == null || params.length == 0) {
            return new Class<?>[0];
        }
        Class<?>[] classes = new Class<?>[params.length];
        for (int i = 0; i < params.length; i++) {
            classes[i] = params[i].getClass();
        }
        return classes;
    }
}
