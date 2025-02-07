package strategy.composite;

public enum PaymentStrategyType {

    DISCOUNT {
        @Override
        public Strategy createStrategy(Object... params) {
            return new DiscountStrategy((Double) params[0]);
        }
    },
    FULLREDUCTION {
        @Override
        public Strategy createStrategy(Object... params) {
            return new FullReductionStrategy((Integer) params[0], (Integer) params[1]);
        }
    },
    ALIPAY {
        @Override
        public Strategy createStrategy(Object... params) {
            return new AlipayStrategy();
        }
    },
    WECHAT {
        @Override
        public Strategy createStrategy(Object... params) {
            return new WechatPayStrategy();
        }
    },
    CREDITCARD {
        @Override
        public Strategy createStrategy(Object... params) {
            return new CreditCardStrategy();
        }
    };


    public abstract Strategy createStrategy(Object... params);
}
