package chain.demo2;

import java.util.ArrayList;
import java.util.List;

public class MsgProcessChain
{
    private List<Process> chains = new ArrayList<>();

    public MsgProcessChain addChain(Process process) {
        chains.add(process);
        return this;
    }

    public void removeChain(Process process) {
        chains.remove(process);
    }

    public void process(String msg) {
        for (Process chain : chains) {
            chain.doProcess(msg);
        }
    }
}
