package builder.fluent;

public interface ComputerBuilder {

    ComputerBuilder buildCpu(String cpu);
    ComputerBuilder buildMemory(String memory);
    ComputerBuilder buildDisk(String disk);
    ComputerBuilder buildGraphicsCard(String graphicsCard);
    ComputerBuilder buildDisplay(String display);
    Computer build();
}
