package proxy.statical;

public class PersonProxy implements IPerson
{
    private final Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    @Override
    public void eat()
    {
        person.eat();
    }

    @Override
    public void sleep()
    {
        person.sleep();
    }
}
