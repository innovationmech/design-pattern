package builder.hierarchies;

import builder.hierarchies.NyPizza.Size;
import builder.hierarchies.Pizza.Topping;

public class HierarchiesDemo
{
    public static void main(String[] args)
    {
        NyPizza pizza = new NyPizza.Builder(Size.SMALL)
            .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
    }
}
