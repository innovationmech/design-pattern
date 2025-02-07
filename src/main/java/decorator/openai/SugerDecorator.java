package decorator.openai;

public class SugerDecorator extends BeverageDecorator {

    public SugerDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
