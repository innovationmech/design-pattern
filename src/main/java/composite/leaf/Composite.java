package composite.leaf;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("组合节点: " + name + " 执行操作");
        for (Component child : children) {
            child.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        if (index < 0 || index >= children.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return children.get(index);
    }
}
