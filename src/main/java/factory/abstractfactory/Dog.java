package factory.abstractfactory;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Dog implements Animal
{
    @Override
    public String getAnimal()
    {
        return "Dog";
    }

    @Override
    public String mkSound()
    {
        return "bark";
    }
}
