package builder.fluent;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        return builder.buildCpu("Intel i7")
                .buildMemory("16GB")
                .buildDisk("1TB")
                .buildGraphicsCard("Nvidia RTX 2080")
                .buildDisplay("4K")
                .build();
    }
}
