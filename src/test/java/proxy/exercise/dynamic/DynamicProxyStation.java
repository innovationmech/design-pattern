package proxy.exercise.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import proxy.exercise.statical.IStation;
import proxy.exercise.statical.Station;

public class DynamicProxyStation implements InvocationHandler
{
    private Station station;

    public IStation getInstance(Station station)
    {
        this.station = station;
        return (IStation) Proxy
            .newProxyInstance(station.getClass().getClassLoader(), station.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object result = null;
        if (method.getName().equals("sellTicket")) {
            System.out.println("收取5元手续费");
            result = method.invoke(station, args);
        }
        return result;
    }
}
