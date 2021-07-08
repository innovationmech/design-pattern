package interpreter;

public class Add extends Operator
{
    public Add(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public int interpreter()
    {
        return left.interpreter() + right.interpreter();
    }
}
