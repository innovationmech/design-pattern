package command.param;

public class Main {

    public static void main(String[] args) {
        AudioReceiver audioReceiver = new AudioReceiver();
        Command setVolume50Command = new SetVolumeCommand(audioReceiver, 50);
        RemoteControllerInvoker remote = new RemoteControllerInvoker();
        remote.setCommand(setVolume50Command);

        remote.pressButton();
        System.out.println("当前音量：" + audioReceiver.getCurrentVolume());
    }
}
