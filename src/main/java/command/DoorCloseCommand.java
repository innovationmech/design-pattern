package command;

public class DoorCloseCommand implements ICommand
{
    private Door door;

    @Override
    public void execute()
    {
        door.closeDoor();
    }

    @Override
    public void undo()
    {
        door.openDoor();
    }
}
