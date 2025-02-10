package builder.fluent;

public class Computer {
    private String cpu;
    private String memory;
    private String disk;
    private String graphicsCard;
    private String display;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
