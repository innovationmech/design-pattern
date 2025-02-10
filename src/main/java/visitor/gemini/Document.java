package visitor.gemini;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void accept(Visitor visitor) {
        for (DocumentElement element : elements) {
            element.accept(visitor);
        }
    }
}
