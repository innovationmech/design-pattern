package flyweight;

public interface Flyweight
{
    // 对外状态对象
    void operation(String name);

    // 对内对象
    String getType();
}
