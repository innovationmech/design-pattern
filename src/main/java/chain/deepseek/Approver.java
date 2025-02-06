package chain.deepseek;

public abstract class Approver {

    protected Approver next;
    protected int maxDays;

    public void setNext(Approver next) {
        Approver oldNext = this.next;
        this.next = next;

        if (hasCycle(this)) {
            this.next = oldNext;
            throw new RuntimeException("Cycle detected");
        }
    }

    public Approver getNext() {
        return next;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getDays() <= maxDays) {
            System.out.println(this.getClass().getSimpleName() + " approved " + request.getDays() + " days"
            );
        } else if (next != null) {
            next.handleRequest(request);
        } else {
            System.out.println("No one can approve");
        }
    }

    private boolean hasCycle(Approver start) {
        if (start == null) {
            return false;
        }
        Approver slow = start;
        Approver fast = start.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
