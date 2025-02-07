package adapter.deepseek;

public class TypeCToUSBAdapter implements USB {

    private TypeCCharger typeCCharger;

    public TypeCToUSBAdapter(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public void charge() {
        typeCCharger.typeCCharge();
    }
}
