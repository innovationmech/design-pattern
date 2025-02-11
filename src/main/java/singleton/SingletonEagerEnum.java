package singleton;

import java.util.ArrayList;
import java.util.List;

// 枚举单例；线程安全
public enum SingletonEagerEnum
{
    INSTANCE;

    public List<String> list = null;

    private SingletonEagerEnum() {
        list = new ArrayList<>();
    }

    public static SingletonEagerEnum getInstance() {
        return INSTANCE;
    }
}
