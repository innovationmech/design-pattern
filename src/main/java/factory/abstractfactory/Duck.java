package factory.abstractfactory;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Duck implements Animal
{

    @Override
    public String getAnimal()
    {
        return "Duck";
    }

    @Override
    public String mkSound()
    {
        return "ga~ga~";
    }
}
