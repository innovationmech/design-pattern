package decorator.openai;

public abstract class BeverageDecorator implements Beverage {

    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}
