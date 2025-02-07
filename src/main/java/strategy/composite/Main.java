package strategy.composite;

public class Main {

    public static void main(String[] args) {
        CompositeStrategy compositeStrategy = new CompositeStrategy();
        compositeStrategy.addStrategy(PaymentStrategyType.FULLREDUCTION, 300, 50);
        compositeStrategy.addStrategy(PaymentStrategyType.DISCOUNT, 0.1);
        compositeStrategy.addStrategy(PaymentStrategyType.ALIPAY);

        PaymentContext context = new PaymentContext(compositeStrategy);
        context.executePayment(350);
    }
}
