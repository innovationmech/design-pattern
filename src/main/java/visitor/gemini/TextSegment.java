package visitor.gemini;

public class TextSegment implements DocumentElement {

    private String text;

    public TextSegment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
