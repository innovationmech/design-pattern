package chain.demo2;

public class TypoProcess implements Process
{
    @Override
    public void doProcess(String msg)
    {
        System.out.println(msg + "敏感词处理");
    }
}
