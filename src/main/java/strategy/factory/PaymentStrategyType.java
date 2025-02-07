package strategy.factory;

public enum PaymentStrategyType {

    ALIPAY {
        @Override
        public PaymentStrategy createStrategy() {
            return new AlipayStrategy();
        }
    },
    WECHAT {
        @Override
        public PaymentStrategy createStrategy() {
            return new WechatPayStrategy();
        }
    },
    CREDITCARD {
        @Override
        public PaymentStrategy createStrategy() {
            return new CreditCardStrategy();
        }
    };


    public abstract PaymentStrategy createStrategy();
}
