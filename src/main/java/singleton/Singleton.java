package singleton;

import java.util.ArrayList;
import java.util.List;


// 静态内部类方式；线程安全
public class Singleton
{
    public List<String> list;

    private Singleton() {
        list = new ArrayList<>();
    }

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
