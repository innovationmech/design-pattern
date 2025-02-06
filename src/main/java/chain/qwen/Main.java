package chain.qwen;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Handler departmentManager = new DepartmentManager("张三");
        Handler financeManager = new FinanceManager("李四");
        Handler generalManager = new GeneralManager("王五");

        ChainManager chainManager = new ChainManager();

        chainManager.addHandler(departmentManager);
        chainManager.addHandler(financeManager);
        chainManager.addHandler(generalManager);

        List<String> handlerNames = Arrays.asList("张三", "李四", "王五");
        chainManager.buildChain(handlerNames);

        Request request1 = new Request("购买办公用品", 800);
        chainManager.processRequest(request1);

        Request request2 = new Request("采购设备", 3000);
        chainManager.processRequest(request2);

        Request request3 = new Request("项目投资", 10000);
        chainManager.processRequest(request3);

        System.out.println("\n--- 动态修改责任链 ---");
        chainManager.removeHandler("李四");
        handlerNames = Arrays.asList("张三", "王五");
        chainManager.buildChain(handlerNames);

        Request request4 = new Request("紧急采购", 7000);
        chainManager.processRequest(request4);
    }
}
