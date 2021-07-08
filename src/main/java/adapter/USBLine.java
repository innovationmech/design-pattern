package adapter;

public class USBLine
{
    void charge(int volt) {
        if (volt != 5) {
            throw new IllegalArgumentException("只接收 5v 电压");
        }
        System.out.println("正常充电");
    }
}
