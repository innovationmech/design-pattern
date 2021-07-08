package decorator.enhance;

import org.junit.Test;

public class Client
{
    @Test
    public void test() {
        IBeauty me = new Me();
        System.out.println("我原本的颜值：" + me.getBeautyValue());

        IBeauty meWithRing = new RingDecorator(me);
        System.out.println("戴上戒指后，我的颜值：" + meWithRing.getBeautyValue());
    }

    @Test
    public void show() {
        IBeauty me = new Me();
        System.out.println("我原本的颜值：" + me.getBeautyValue());

        // 随意挑选装饰
        IBeauty meWithNecklace = new NecklaceDecorator(me);
        System.out.println("戴上了项链后，我的颜值：" + meWithNecklace.getBeautyValue());

        // 多次装饰
        IBeauty meWithManyDecorators = new NecklaceDecorator(new RingDecorator(new EarringDecorator(me)));
        System.out.println("戴上耳环、戒指、项链后，我的颜值：" + meWithManyDecorators.getBeautyValue());

        // 任意搭配装饰
        IBeauty meWithNecklaceAndRing = new NecklaceDecorator(new RingDecorator(me));
        System.out.println("戴上戒指、项链后，我的颜值：" + meWithNecklaceAndRing.getBeautyValue());
    }
}
