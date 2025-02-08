package state.table;

public class Main {

    public static void main(String[] args) {
        OrderContextWithTable order = new OrderContextWithTable();

        System.out.println("当前订单状态: " + order.getState().getStateDescription());
        order.processShipping();
        order.processPayment();
        System.out.println("当前订单状态: " + order.getState().getStateDescription());
        order.processShipping();
        System.out.println("当前订单状态: " + order.getState().getStateDescription());
        order.completeOrder();
        System.out.println("当前订单状态: " + order.getState().getStateDescription());
        order.completeOrder(); // 再次尝试完成，验证状态保持不变
        System.out.println("当前订单状态: " + order.getState().getStateDescription());
    }
}
