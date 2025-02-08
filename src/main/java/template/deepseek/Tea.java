package template.deepseek;

public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

    // 覆盖钩子方法：控制是否添加调料
    @Override
    protected boolean needCondiments() {
        return false; // 茶不需要调料
    }
}
