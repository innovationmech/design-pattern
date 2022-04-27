package bridge.vehicle;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Assemble implements WorkShop
{
    @Override
    public void work()
    {
        System.out.print(" And");
        System.out.println(" Assembled");
    }
}
