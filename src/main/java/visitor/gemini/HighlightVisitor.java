package visitor.gemini;

public class HighlightVisitor implements Visitor {

    @Override
    public void visit(DocumentElement element) {
        if (element instanceof TextSegment) {
            TextSegment textElement = (TextSegment) element;
            System.out.println("高亮文本: " + textElement.getText());
            // 实际高亮文本的操作...
        }
    }
}
