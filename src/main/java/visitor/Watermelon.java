package visitor;

public class Watermelon extends Food
{
    @Override
    public String name()
    {
        return "watermelon";
    }

    @Override
    public void accept(IVisitor visitor)
    {
        visitor.chooseFood(this);
    }
}
