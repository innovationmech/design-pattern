package builder;

public class Outer
{
    private int outProp = 8;

    static class Inner {
        private int inProp = 5;
    }

    // 外部类可以访问内部类的私有对象
    public void accessInnerProp() {
        System.out.println(new Inner().inProp);
    }

    public static void main(String[] args)
    {
        Outer outer = new Outer();
        outer.accessInnerProp();
    }
}
