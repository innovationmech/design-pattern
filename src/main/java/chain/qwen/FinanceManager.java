package chain.qwen;

public class FinanceManager extends AbstractHandler {

    public FinanceManager(String name) {
        super(name);
    }

    @Override
    public void handle(Request request) {
        if (request.getAmount() <= 5000) {
            System.out.println(name + "（财务主管）已批准：" + request.getContent());
        } else if (next != null) {
            System.out.println(name + "（财务主管）无法处理，转交给下一个处理者...");
            next.handle(request);
        } else {
            System.out.println("没有后续处理者，请求被拒绝：" + request.getContent());
        }
    }
}
