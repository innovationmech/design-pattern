package bridge.vehicle;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Bike extends Vehicle
{
    public Bike(WorkShop workShop1, WorkShop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        System.out.println("Bike ");
        workShop1.work();
        workShop2.work();
    }
}
