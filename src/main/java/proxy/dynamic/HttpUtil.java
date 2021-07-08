package proxy.dynamic;

public class HttpUtil implements IHttp
{
    @Override
    public void request(String sendData)
    {
        System.out.println("网络请求中...");
    }

    @Override
    public void onSuccess(String receivedData)
    {
        System.out.println("网络请求成功.");
    }
}
