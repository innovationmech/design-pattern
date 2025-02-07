package composite.leaf;

public class Main {

    public static void main(String[] args) {
        Component leaf1 = new Leaf("Leaf1");
        Component leaf2 = new Leaf("Leaf2");

        Composite composite1 = new Composite("Composite1");
        composite1.add(leaf1);
        composite1.add(leaf2);

        Composite composite2 = new Composite("Composite2");
        composite2.add(composite1);
        composite2.add(new Leaf("Leaf3"));

        composite2.operation();
    }
}
