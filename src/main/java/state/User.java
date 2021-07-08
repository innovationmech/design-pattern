package state;

public class User implements IUser, ISwitchState
{
    IUser state = new Normal();

    @Override
    public void purchasePlus()
    {
        state = new Plus();
    }

    @Override
    public void expire()
    {
        state = new Normal();
    }

    @Override
    public void mockInterView()
    {
        state.mockInterView();
    }
}
