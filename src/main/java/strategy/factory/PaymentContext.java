package strategy.factory;

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategyType strategyType) {
        this.paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(strategyType);
    }

    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategyType strategyType) {
        this.paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(strategyType);
    }
}
