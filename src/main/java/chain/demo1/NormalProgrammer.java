package chain.demo1;

public class NormalProgrammer extends AbstractProgrammer
{
    @Override
    void handle(Bug bug)
    {
        if (bug.value > 20 && bug.value <= 50) {
            solve(bug);
        } else if (next != null) {
            next.handle(bug);
        }
    }

    private void solve(Bug bug) {
        System.out.println("普通程序员解决了一个难度为 " + bug.value + " 的 bug");
    }
}
