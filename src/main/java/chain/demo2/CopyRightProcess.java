package chain.demo2;

public class CopyRightProcess implements Process
{
    @Override
    public void doProcess(String msg)
    {
        System.out.println(msg + "版权处理");
    }
}
