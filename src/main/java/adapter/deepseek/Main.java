package adapter.deepseek;

public class Main {

    public static void main(String[] args) {
        TypeCCharger typeCCharger = new TypeCCharger();
        USB usb = new TypeCToUSBAdapter(typeCCharger);
        usb.charge();
    }
}
