package factory.abstractfactory;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public interface AbstractFactory<T>
{
    T create(String animalType);
}
