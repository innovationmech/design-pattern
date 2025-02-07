package decorator.openai;

public class Main {

    public static void main(String[] args) {
        Beverage basicCoffee = new BasicCoffee();
        System.out.println("Basic Coffee: " + basicCoffee.getDescription() + ", Cost: $" + basicCoffee.cost());

        Beverage milkCoffee = new MilkDecorator(basicCoffee);
        System.out.println("Milk Coffee: " + milkCoffee.getDescription() + ", Cost: $" + milkCoffee.cost());

        Beverage milkSugarCoffee = new SugerDecorator(milkCoffee);
        System.out.println("Milk Sugar Coffee: " + milkSugarCoffee.getDescription() + ", Cost: $" + milkSugarCoffee.cost());
    }
}
