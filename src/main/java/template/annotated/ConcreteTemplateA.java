package template.annotated;

public class ConcreteTemplateA extends AbstractTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteTemplateA step1");
    }

    @Override
    @Hook
    protected void step2() {
        System.out.println("ConcreteTemplateA step2");
    }
}
