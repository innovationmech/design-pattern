package singleton;

import java.util.ArrayList;
import java.util.List;

// 双重检查锁定；线程安全
public class SingletonLazy
{

    // volatile 防止指令重排序
    private volatile static SingletonLazy instance = null;

    private List<String> list = null;

    private SingletonLazy() {
        list = new ArrayList<>();
    }

    public static SingletonLazy getInstance() {
        if (null == instance) { // 第一次检查，是为了减少同步开销，只有instance为null时才进入同步代码块
            synchronized (SingletonLazy.class) {
                if (null == instance) { // 第二次检查，是为了确保只有一个线程能够创建实例
                    // 编译后指令：1. 分配对象的内存空间 2. 初始化对象 3. 将变量 instance 指向刚分配的内存空间
                    // 使用 volatile 后，避免其他线程拿到未初始化的 SingletonLazy 对象
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
