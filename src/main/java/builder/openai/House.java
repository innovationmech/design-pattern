package builder.openai;

public class House {

    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
    public void setStructure(String structure) {
        this.structure = structure;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }
    public void setInterior(String interior) {
        this.interior = interior;
    }

    public void showHouse() {
        System.out.println("Foundation: " + foundation);
        System.out.println("Structure: " + structure);
        System.out.println("Roof: " + roof);
        System.out.println("Interior: " + interior);
    }

}
