package command;

public class LightOnCommand implements ICommand
{
    private Light light;

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.lightOn();
    }

    @Override
    public void undo()
    {
        light.lightOff();
    }
}
