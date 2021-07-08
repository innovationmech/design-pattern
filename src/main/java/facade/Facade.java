package facade;

public class Facade
{
    public void open() {
        Browser.open();
        IDE.open();
        WeChat.open();
    }

    public void close() {
        Browser.close();
        Browser.close();
        Browser.close();
    }
}
