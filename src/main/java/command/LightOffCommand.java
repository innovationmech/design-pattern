package command;

public class LightOffCommand implements ICommand
{
    private Light light;

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.lightOff();
    }

    @Override
    public void undo()
    {
        light.lightOn();
    }
}
