package template.annotated;

import java.lang.reflect.Method;

public abstract class AbstractTemplate {

    public final void templateMethod() {
        step1();
        if (isHookEnabled()) {
            step2();
        }
        step3();

    }

    protected abstract void step1();


    @Hook(description = "step2")
    protected void step2() {
        System.out.println("step2");
    }

    private void step3() {
        System.out.println("step3");
    }

    private boolean isHookEnabled() {
        try {
            Method method = this.getClass().getDeclaredMethod("step2");
            return method.isAnnotationPresent(Hook.class);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
