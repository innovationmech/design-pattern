package decorator.mail;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 计算促销后的商品价格
 */
public class PromotionFactory
{

    public static BigDecimal getPayMoney(OrderDetail orderDetail) {
        // 获取给商品设定的促销类型
        Map<PromotionType, SupportPromotions> supportPromotionsList = orderDetail.getMerchandise().getSupportPromotions();

        IBaseCount baseCount = new BaseCount();
        if (supportPromotionsList != null && supportPromotionsList.size() > 0) {
            for (PromotionType promotionType : supportPromotionsList.keySet()) {
                baseCount = promotion(supportPromotionsList.get(promotionType), baseCount);
            }
        }
        return baseCount.countPayMoney(orderDetail);
    }

    /**
     * 组合促销类型
     * @param supportPromotions
     * @param baseCount
     * @return
     */
    private static IBaseCount promotion(SupportPromotions supportPromotions, IBaseCount baseCount) {
        if (supportPromotions.getPromotionType() == PromotionType.COUPON) {
            baseCount = new CouponDecorator(baseCount);
        } else if (supportPromotions.getPromotionType() == PromotionType.REDPACKED) {
            baseCount = new RedPacketDecorator(baseCount);
        }
        return baseCount;
    }
}
