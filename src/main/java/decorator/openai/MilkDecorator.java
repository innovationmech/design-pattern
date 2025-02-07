package decorator.openai;

public class MilkDecorator extends BeverageDecorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}
