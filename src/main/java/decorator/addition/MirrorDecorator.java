package decorator.addition;

public class MirrorDecorator implements IMirrorHouse
{
    private final IHouse house;

    public MirrorDecorator(IHouse house)
    {
        this.house = house;
    }

    @Override
    public void lookMirror()
    {
        System.out.println("有了镜子后，新增了照镜子功能");
    }

    @Override
    public void live()
    {
        house.live();
    }
}
