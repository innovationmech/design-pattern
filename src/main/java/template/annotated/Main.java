package template.annotated;

public class Main {

    public static void main(String[] args) {
        AbstractTemplate templateA = new ConcreteTemplateA();
        System.out.println("--- 模板 A 执行 ---");
        templateA.templateMethod();

        AbstractTemplate templateB = new ConcreteTemplateB();
        System.out.println("\n--- 模板 B 执行 ---");
        templateB.templateMethod();
    }
}
