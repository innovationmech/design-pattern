package singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton
{
    public List<String> list = null;

    private Singleton() {
        list = new ArrayList<>();
    }

    static class InnerSingleton {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerSingleton.instance;
    }
}
