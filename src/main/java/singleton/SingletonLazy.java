package singleton;

import java.util.ArrayList;
import java.util.List;

public class SingletonLazy
{
    private volatile static SingletonLazy instance = null;

    private List<String> list = null;

    private SingletonLazy() {
        list = new ArrayList<>();
    }

    public static SingletonLazy getInstance() {
        if (null == instance) {
            synchronized (SingletonLazy.class) {
                if (null == instance) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
