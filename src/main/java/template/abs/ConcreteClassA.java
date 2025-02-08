package template.abs;

public class ConcreteClassA extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("class A - step 1");
    }

    @Override
    protected void step2() {
        System.out.println("class A - step 2");
    }

    @Override
    protected void hook() {
        System.out.println("class A - hook");
    }
}
