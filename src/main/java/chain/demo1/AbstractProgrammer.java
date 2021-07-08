package chain.demo1;

public abstract class AbstractProgrammer
{
    protected AbstractProgrammer next;

    public void setNext(AbstractProgrammer next) {
        this.next = next;
    }

    abstract void handle(Bug bug);
}
