package strategy.composite;

public class WechatPayStrategy implements Strategy {
    @Override
    public int execute(int amount) {
        System.out.println("通过微信支付：" + amount + "元");
        return amount;
    }
}
