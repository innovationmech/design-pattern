package visitor.gemini;

public interface DocumentElement {

    void accept(Visitor visitor);
}
