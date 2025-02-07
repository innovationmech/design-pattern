package strategy.composite;

public class DiscountStrategy implements Strategy {

    private double discountRate;

    public DiscountStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int execute(int amount) {
        double discountAmount = amount * (1 - discountRate);
        System.out.println("应用打折策略后支付金额：" + discountAmount + "元");
        return (int) discountAmount;
    }
}
