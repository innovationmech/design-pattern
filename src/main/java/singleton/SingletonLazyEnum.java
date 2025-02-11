package singleton;

import java.util.ArrayList;
import java.util.List;

public class SingletonLazyEnum
{
    private List<String> list = null;

    private SingletonLazyEnum() {
        list = new ArrayList<>();
    }

    private enum EnumSingleton {
        INSTANCE;

        private SingletonLazyEnum instance = null;

        EnumSingleton() {
            this.instance = new SingletonLazyEnum();
        }

        public SingletonLazyEnum getInstance()
        {
            return instance;
        }
    }

    public static SingletonLazyEnum getInstance() {
        return EnumSingleton.INSTANCE.getInstance();
    }
}
