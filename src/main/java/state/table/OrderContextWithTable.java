package state.table;

import java.util.HashMap;
import java.util.Map;

public class OrderContextWithTable {

    private OrderState state;
    private Map<Class<? extends OrderState>, Map<OrderEvent, Class<? extends OrderState>>> stateTransitionTable;

    public OrderContextWithTable() {
        this.state = new PendingPaymentState();
        initializeTransitionTable();
    }

    private void initializeTransitionTable() {
        stateTransitionTable = new HashMap<>();

        Map<OrderEvent, Class<? extends OrderState>> pendingPaymentTransactions = new HashMap<>();
        pendingPaymentTransactions.put(OrderEvent.PAYMENT_PROCESSED, PaidState.class);
        pendingPaymentTransactions.put(OrderEvent.SHIPPING_PROCESSED, PendingPaymentState.class);
        pendingPaymentTransactions.put(OrderEvent.ORDER_COMPLETED, PendingPaymentState.class);
        stateTransitionTable.put(PendingPaymentState.class, pendingPaymentTransactions);

        Map<OrderEvent, Class<? extends OrderState>> paidTransactions = new HashMap<>();
        paidTransactions.put(OrderEvent.PAYMENT_PROCESSED, PaidState.class);
        paidTransactions.put(OrderEvent.SHIPPING_PROCESSED, ShippedState.class);
        paidTransactions.put(OrderEvent.ORDER_COMPLETED, PaidState.class);
        stateTransitionTable.put(PaidState.class, paidTransactions);

        Map<OrderEvent, Class<? extends OrderState>> shippedTransactions = new HashMap<>();
        shippedTransactions.put(OrderEvent.PAYMENT_PROCESSED, ShippedState.class);
        shippedTransactions.put(OrderEvent.SHIPPING_PROCESSED, ShippedState.class);
        shippedTransactions.put(OrderEvent.ORDER_COMPLETED, CompletedState.class);
        stateTransitionTable.put(ShippedState.class, shippedTransactions);

        Map<OrderEvent, Class<? extends OrderState>> completedTransactions = new HashMap<>();
        completedTransactions.put(OrderEvent.PAYMENT_PROCESSED, CompletedState.class);
        completedTransactions.put(OrderEvent.SHIPPING_PROCESSED, CompletedState.class);
        completedTransactions.put(OrderEvent.ORDER_COMPLETED, CompletedState.class);
        stateTransitionTable.put(CompletedState.class, completedTransactions);
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    public void changeState(OrderEvent event) {
        Class<? extends OrderState> currentStateClass = state.getClass();
        Map<OrderEvent, Class<? extends OrderState>> transitionsForCurrentState = stateTransitionTable.get(currentStateClass);

        if (transitionsForCurrentState != null && transitionsForCurrentState.containsKey(event)) {
            Class<? extends OrderState> nextStateClass = transitionsForCurrentState.get(event);
            try {
                setState(nextStateClass.newInstance());
                System.out.println("Changed state from " + currentStateClass.getSimpleName() + " to " + nextStateClass.getSimpleName());
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Failed to change state");
            }
        } else {
            System.out.println("Invalid transition");
        }
    }

    public void processPayment() {
        state.handlePayment(this);
    }

    public void processShipping() {
        state.handleShipping(this);
    }

    public void completeOrder() {
        state.handleCompletion(this);
    }
}
