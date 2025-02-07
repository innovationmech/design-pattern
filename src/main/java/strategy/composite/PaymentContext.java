package strategy.composite;

public class PaymentContext {

    private Strategy strategy;

    public PaymentContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        int finalAmount = strategy.execute(amount);
        System.out.println("最终支付金额：" + finalAmount + "元");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
