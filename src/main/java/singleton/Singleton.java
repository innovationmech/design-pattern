package singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton
{
    public List<String> list;

    private Singleton() {
        list = new ArrayList<>();
    }

    private static class InnerSingleton {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerSingleton.instance;
    }
}
