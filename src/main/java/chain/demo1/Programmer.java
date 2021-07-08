package chain.demo1;

public class Programmer
{
    public String type;

    public Programmer(String type) {
        this.type = type;
    }

    public void solve(Bug bug) {
        System.out.println(type + "程序员解决了一个难度为 " + bug.value + " 的 bug");
    }
}
