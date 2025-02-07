package strategy.factory;

public class WechatPayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("微信支付" + amount + "元");
    }
}
