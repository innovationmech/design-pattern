package builder.openai;

public interface HouseBuilder {

    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void buildInterior();
    House getHouse();
}
