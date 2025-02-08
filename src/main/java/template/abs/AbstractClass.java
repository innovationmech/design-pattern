package template.abs;

public abstract class AbstractClass {

    public final void templateMethod() {
        step1();
        step2();
        step3();
        hook();
    }

    protected abstract void step1();
    protected abstract void step2();

    private void step3() {
        System.out.println("step3");
    }

    protected void hook() {
    }
}
