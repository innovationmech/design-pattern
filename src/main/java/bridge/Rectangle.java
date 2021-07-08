package bridge;

public class Rectangle implements IShape
{
    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw()
    {
        System.out.println("绘制" + color.getColor() + "矩形");
    }
}
