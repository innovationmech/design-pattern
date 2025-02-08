package command.param;

public class SetVolumeCommand implements Command {

    private AudioReceiver audioReceiver;
    private int volumeLevel;

    public SetVolumeCommand(AudioReceiver audioReceiver, int volumeLevel) {
        this.audioReceiver = audioReceiver;
        this.volumeLevel = volumeLevel;
    }

    @Override
    public void execute() {
        audioReceiver.setVolume(volumeLevel);
    }

    @Override
    public void undo() {
        audioReceiver.decreaseVolume(volumeLevel);
    }
}
