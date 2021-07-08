package adapter.obj;

public class AdapterPatternObj
{
    public static void main(String[] args)
    {
        Target mAdapter = new Adapter(new Adaptee());
        mAdapter.request();
    }
}
