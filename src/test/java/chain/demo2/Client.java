package chain.demo2;

import org.junit.Test;

public class Client
{
    @Test
    public void test01()
    {
        String msg = "abced===";
        MsgProcessChain chain = new MsgProcessChain()
            .addChain(new SensitiveWordProcess())
            .addChain(new TypoProcess())
            .addChain(new CopyRightProcess());
        chain.process(msg);
    }
}
