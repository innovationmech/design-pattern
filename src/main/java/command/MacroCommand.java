package command;

import java.util.List;

public class MacroCommand implements ICommand
{
    List<ICommand> commands;

    public MacroCommand(List<ICommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        for (ICommand command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo()
    {
        for (ICommand command : commands) {
            command.undo();
        }
    }
}
