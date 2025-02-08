package state.gemini;

public class Main {

    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        System.out.println("当前订单状态: " + order.getState().getStateDescription()); // 输出：当前订单状态: 待支付
        order.processShipping(); // 输出：订单待支付，无法发货。
        order.processPayment();  // 输出：订单待支付，正在处理支付...
        //      支付完成，订单状态更新为： 已支付
        System.out.println("当前订单状态: " + order.getState().getStateDescription()); // 输出：当前订单状态: 已支付
        order.processShipping(); // 输出：订单已支付，正在准备发货...
        //      已发货，订单状态更新为： 已发货
        System.out.println("当前订单状态: " + order.getState().getStateDescription()); // 输出：当前订单状态: 已发货
        order.completeOrder();   // 输出：订单已发货，正在完成订单...
        //      订单已完成，状态更新为： 已完成
        System.out.println("当前订单状态: " + order.getState().getStateDescription()); // 输出：当前订单状态: 已完成
    }
}
