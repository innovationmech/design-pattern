package strategy.factory;

public class AlipayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Alipay " + amount);
    }
}
