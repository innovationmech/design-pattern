package decorator.openai;

public class BasicCoffee implements Beverage {
    @Override
    public double cost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }
}
