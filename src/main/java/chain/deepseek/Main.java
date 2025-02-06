package chain.deepseek;

public class Main {

    public static void main(String[] args) {
        TeamLeader tl = new TeamLeader();
        DepartmentManager dm = new DepartmentManager();
        GeneralManager gm = new GeneralManager();

        tl.setNext(dm);
        dm.setNext(gm);

        ApprovalChain chain = new ApprovalChain();
        chain.setHead(tl);

        chain.processRequest(new LeaveRequest(3));
        chain.processRequest(new LeaveRequest(5));
        chain.processRequest(new LeaveRequest(8));

        DepartmentManager newDm = new DepartmentManager();
        newDm.setMaxDays(5);
        GeneralManager newGm = new GeneralManager();

        try {
            tl.setNext(newDm);
            newDm.setNext(newGm);
            newGm.setNext(tl);
        } catch (Exception e) {
            System.out.println("操作失败：" + e.getMessage());
        }
    }
}
