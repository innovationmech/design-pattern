package decorator.enhance;

public class EarringDecorator implements IBeauty
{
    private final IBeauty me;

    public EarringDecorator(IBeauty me)
    {
        this.me = me;
    }

    @Override
    public int getBeautyValue()
    {
        return me.getBeautyValue() + 50;
    }
}
