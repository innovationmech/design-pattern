package chain.demo1;

import org.junit.Test;

public class Client
{
    @Test
    public void test1() {
        Programmer newbie = new Programmer("菜鸟");
        Programmer normal = new Programmer("普通");
        Programmer good = new Programmer("优秀");

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        handleBug(newbie, easy);
        handleBug(normal, easy);
        handleBug(good, easy);

        handleBug(newbie, middle);
        handleBug(normal, middle);
        handleBug(good, middle);

        handleBug(newbie, hard);
        handleBug(normal, hard);
        handleBug(good, hard);
    }

    public boolean handleBug(Programmer programmer, Bug bug) {
        if (programmer.type.equals("菜鸟") && bug.value > 0 && bug.value <= 20) {
            programmer.solve(bug);
            return true;
        } else if (programmer.type.equals("普通") && bug.value > 20 && bug.value <= 50) {
            programmer.solve(bug);
            return true;
        } else if (programmer.type.equals("优秀") && bug.value > 50 && bug.value <= 100) {
            programmer.solve(bug);
            return true;
        }
        return false;
    }

    @Test
    public void test2() {
        ProjectManager manager = new ProjectManager();

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        manager.assignBug(easy);
        manager.assignBug(middle);
        manager.assignBug(hard);
    }

    @Test
    public void test3() throws Exception {
        Programmer newbie = new Programmer("菜鸟");
        Programmer normal = new Programmer("普通");
        Programmer good = new Programmer("优秀");

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        if (!handleBug(newbie, easy)) {
            if (!handleBug(normal, easy)) {
                if (!handleBug(good, easy)) {
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }

        if (!handleBug(newbie, middle)) {
            if (!handleBug(normal, middle)) {
                if (!handleBug(good, middle)) {
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }

        if (!handleBug(newbie, hard)) {
            if (!handleBug(normal, hard)) {
                if (!handleBug(good, hard)) {
                    throw new Exception("Kill the fake good programmer!");
                }
            }
        }
    }

    @Test
    public void test4() {
        NewbieProgrammer newbie = new NewbieProgrammer();
        NormalProgrammer normal = new NormalProgrammer();
        GoodProgrammer good = new GoodProgrammer();

        Bug easy = new Bug(20);
        Bug middle = new Bug(50);
        Bug hard = new Bug(100);

        newbie.setNext(normal);
        normal.setNext(good);

        newbie.handle(easy);
        newbie.handle(middle);
        newbie.handle(hard);
    }
}
