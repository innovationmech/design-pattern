package memento.gemini;

import java.util.ArrayList;
import java.util.List;

// 管理者角色
public class Caretaker {

    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
