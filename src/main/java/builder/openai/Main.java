package builder.openai;

public class Main {

    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();

        HouseDirector director = new HouseDirector(builder);
        House house = director.constructHouse();

        house.showHouse();
    }
}
