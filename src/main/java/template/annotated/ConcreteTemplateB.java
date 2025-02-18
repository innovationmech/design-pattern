package template.annotated;

public class ConcreteTemplateB extends AbstractTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteTemplateB step1");
    }
}
