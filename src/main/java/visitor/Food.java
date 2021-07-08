package visitor;

public abstract class Food
{
    public abstract String name();

    public abstract void accept(IVisitor visitor);
}
