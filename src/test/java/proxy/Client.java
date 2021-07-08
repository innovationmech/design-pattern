package proxy;

import org.junit.Test;
import proxy.dynamic.HttpProxy;
import proxy.dynamic.HttpUtil;
import proxy.dynamic.IHttp;
import proxy.statical.Person;
import proxy.statical.PersonProxy;

public class Client
{
    @Test
    public void test() {
        Person person = new Person();
        person.eat();
        person.sleep();
    }

    @Test
    public void test2() {
        Person person = new Person();
        PersonProxy proxy = new PersonProxy(person);
        proxy.eat();
        proxy.sleep();
    }

    @Test
    public void test3() {
        HttpUtil httpUtil = new HttpUtil();
        IHttp proxy = new HttpProxy().getInstance(httpUtil);
        proxy.request("request data");
        proxy.onSuccess("received result");
    }
}
