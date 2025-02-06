package chain.qwen;

public class GeneralManager extends AbstractHandler {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handle(Request request) {
        System.out.println(name + "（总经理）已批准：" + request.getContent());
    }
}
