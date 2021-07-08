package chain.demo1;

public class ProjectManager
{
    Programmer newbie = new Programmer("菜鸟");
    Programmer normal = new Programmer("普通");
    Programmer good = new Programmer("优秀");

    public void assignBug(Bug bug) {
        if (bug.value > 0 && bug.value <= 20) {
            System.out.println("项目经理将这个简单的 bug 分配给了菜鸟程序员");
            newbie.solve(bug);
        } else if (bug.value > 20 && bug.value <= 50) {
            System.out.println("项目经理将这个中等的 bug 分配给了普通程序员");
            normal.solve(bug);
        } else if (bug.value > 50 && bug.value <= 100) {
            System.out.println("项目经理将这个困难的 bug 分配给了优秀程序员");
            good.solve(bug);
        }
    }
}
