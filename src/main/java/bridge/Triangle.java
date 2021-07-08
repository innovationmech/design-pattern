package bridge;

public class Triangle implements IShape
{
    private IColor color;

    void setColor(IColor color) {
        this.color = color;
    }

    @Override
    public void draw()
    {
        System.out.println("绘制" + color.getColor() + "三角形");
    }
}
