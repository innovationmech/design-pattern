package adapter.clazz;

public class AdapterPatternClazz
{
    public static void main(String[] args)
    {
        Target mAdapter = new Adapter();
        mAdapter.request();
    }
}
