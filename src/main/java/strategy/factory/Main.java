package strategy.factory;

public class Main {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(PaymentStrategyType.ALIPAY);

        context.pay(100);

        context.setPaymentStrategy(PaymentStrategyType.WECHAT);
        context.pay(200);

        context.setPaymentStrategy(PaymentStrategyType.CREDITCARD);
        context.pay(300);

        context.setPaymentStrategy(PaymentStrategyType.ALIPAY);
        context.pay(150);
    }
}
