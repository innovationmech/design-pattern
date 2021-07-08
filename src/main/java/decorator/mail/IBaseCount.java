package decorator.mail;

import java.math.BigDecimal;

/**
 * 计算支付金额的接口
 */
public interface IBaseCount
{
    BigDecimal countPayMoney(OrderDetail orderDetail);
}
