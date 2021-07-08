package proxy.exercise.dynamic;

import org.junit.Test;
import proxy.exercise.statical.IStation;
import proxy.exercise.statical.Station;

public class Client
{
    @Test
    public void test01() {
        IStation station = new DynamicProxyStation().getInstance(new Station());
        station.sellTicket();
    }
}
