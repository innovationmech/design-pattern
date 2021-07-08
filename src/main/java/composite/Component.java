package composite;

public abstract class Component
{
    private String position;

    private String job;

    public Component(String position, String job) {
        this.position = position;
        this.job = job;
    }

    public void work() {
        System.out.println("我是" + position + "，我正在" + job);
    }

    abstract void addComponent(Component component);

    abstract void removeComponent(Component component);

    abstract void check();
}
