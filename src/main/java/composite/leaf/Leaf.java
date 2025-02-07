package composite.leaf;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("叶子节点 " + name + " 执行操作");
    }
}
