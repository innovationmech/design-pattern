package proxy.dynamic;

public interface IHttp
{
    void request(String sendData);

    void onSuccess(String receivedData);
}
