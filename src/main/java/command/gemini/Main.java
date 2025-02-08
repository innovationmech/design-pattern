package command.gemini;

public class Main {

    public static void main(String[] args) {
        LightReceiver light = new LightReceiver();

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        RemoteControllerInvoker remote = new RemoteControllerInvoker();
        remote.setCommand(lightOn);

        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
        remote.undoButton();
    }
}
