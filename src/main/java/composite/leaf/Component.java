package composite.leaf;

public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();

    public void add(Component component) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("不支持该操作");
    }
}
