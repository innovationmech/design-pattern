package template.deepseek;

public abstract class Beverage {

    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (needCondiments()) {
            addCondiments();
        }
    }

    // 具体方法
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // 抽象方法
    protected abstract void brew();

    // 具体方法
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 抽象方法
    protected abstract void addCondiments();

    // 钩子方法
    protected boolean needCondiments() {
        return true;
    }
}
