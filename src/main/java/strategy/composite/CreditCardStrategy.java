package strategy.composite;

public class CreditCardStrategy implements Strategy {
    @Override
    public int execute(int amount) {
        System.out.println("通过信用卡支付：" + amount + "元");
        return amount;
    }
}
