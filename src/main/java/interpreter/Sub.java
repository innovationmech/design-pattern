package interpreter;

public class Sub extends Operator
{
    public Sub(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public int interpreter()
    {
        return left.interpreter() - right.interpreter();
    }
}
