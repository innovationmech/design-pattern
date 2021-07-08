package proto;

public class Client
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        ConcretePrototype cp = new ConcretePrototype();
        for (int i = 0; i < 10; i++) {
            ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
            clonecp.show();
        }
    }
}

class Prototype implements Cloneable {

    @Override
    protected Prototype clone() throws CloneNotSupportedException
    {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcretePrototype extends Prototype {
    public void show() {
        System.out.println("原型模式实现类");
    }
}
