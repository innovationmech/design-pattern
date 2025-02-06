package chain.deepseek;

public class ApprovalChain {

    private Approver head;

    public void setHead(Approver approver) {
        this.head = approver;
    }

    public void processRequest(LeaveRequest request) {
        if (head != null) {
            head.handleRequest(request);
        } else {
            System.out.println("没有审批人");
        }
    }
}
