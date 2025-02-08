package command.param;

public class AudioReceiver {

    private int currentVolume = 0; //  当前音量

    public void setVolume(int level) {
        if (level >= 0 && level <= 100) {
            currentVolume = level;
            System.out.println("音响音量设置为: " + currentVolume);
        } else {
            System.out.println("音量设置无效，请设置 0-100 之间的音量值");
        }
    }

    public void decreaseVolume(int level) { //  为了简化 undo 而添加
        if (currentVolume - level >= 0) {
            currentVolume -= level;
            System.out.println("音响音量减小 " + level + "，当前音量为: " + currentVolume);
        } else {
            currentVolume = 0;
            System.out.println("音量已减小到最小");
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
