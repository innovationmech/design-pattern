package decorator.addition;

public class StickyHookDecorator implements IStickyHookHouse
{
    private final IHouse house;

    public StickyHookDecorator(IHouse house)
    {
        this.house = house;
    }

    @Override
    public void hangThings()
    {
        house.live();
    }

    @Override
    public void live()
    {
        System.out.println("有了粘钩后，新增了挂东西的功能");
    }
}
