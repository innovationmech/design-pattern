package template.abs;

public class Main {

    public static void main(String[] args) {
        AbstractClass objectA = new ConcreteClassA();
        objectA.templateMethod();

        AbstractClass objectB = new ConcreteClassB();
        objectB.templateMethod();
    }
}
