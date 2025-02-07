package strategy.composite;

public class FullReductionStrategy implements Strategy {

    private int threshold;
    public int reduction;

    public FullReductionStrategy(int threshold, int reduction) {
        this.threshold = threshold;
        this.reduction = reduction;
    }

    @Override
    public int execute(int amount) {
        if (amount >= threshold) {
            amount -= reduction;
            System.out.println("应用满减策略后支付金额：" + amount + "元");
        } else {
            System.out.println("不满足满减策略，支付金额：" + amount + "元");
        }
        return amount;
    }
}
