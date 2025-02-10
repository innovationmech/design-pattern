package builder.fluent;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder buildCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder buildMemory(String memory) {
        computer.setMemory(memory);
        return this;
    }

    @Override
    public ComputerBuilder buildDisk(String disk) {
        computer.setDisk(disk);
        return this;
    }

    @Override
    public ComputerBuilder buildGraphicsCard(String graphicsCard) {
        computer.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public ComputerBuilder buildDisplay(String display) {
        computer.setDisplay(display);
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}
