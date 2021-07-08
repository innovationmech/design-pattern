package decorator;

public class CurtainDecorator extends BaseDecorator
{
    public CurtainDecorator(IDecorator decorator)
    {
        super(decorator);
    }

    @Override
    public void decorate()
    {
        System.out.println("窗帘装饰。。。");
        super.decorate();
    }

    public static void main(String[] args)
    {
        IDecorator decorator = new Decorator();
        IDecorator curtainDecorator = new CurtainDecorator(decorator);
        curtainDecorator.decorate();
    }
}
