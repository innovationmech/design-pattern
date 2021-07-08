package visitor;

public class Banana extends Food
{
    @Override
    public String name()
    {
        return "banana";
    }

    @Override
    public void accept(IVisitor visitor)
    {
        visitor.chooseFood(this);
    }
}
