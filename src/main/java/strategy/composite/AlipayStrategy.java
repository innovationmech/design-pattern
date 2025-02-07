package strategy.composite;

public class AlipayStrategy implements Strategy {
    @Override
    public int execute(int amount) {
        System.out.println("通过支付宝支付：" + amount + "元");
        return amount;
    }
}
