package strategy.annotated;

public class Order {

    private String orderId;

    private String orderType;

    public Order(String orderId, String orderType) {
        this.orderId = orderId;
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
