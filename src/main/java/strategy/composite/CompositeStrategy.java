package strategy.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeStrategy implements Strategy {

    private final List<Strategy> strategies = new ArrayList<>();

    public void addStrategy(PaymentStrategyType type, Object... params) {
        strategies.add(StrategyFactory.getStrategy(type, params));
    }

    @Override
    public int execute(int amount) {
        for (Strategy strategy : strategies) {
            amount = strategy.execute(amount);
        }
        return amount;
    }
}
