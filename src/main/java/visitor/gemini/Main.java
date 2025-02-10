package visitor.gemini;

public class Main {

    public static void main(String[] args) {
        Document document = new Document();
        document.addElement(new TextSegment("这是一个段落。"));
        document.addElement(new ImageSegment("图片1.jpg"));
        document.addElement(new TextSegment("这是另一个段落。"));

        Visitor highlightVisitor = new HighlightVisitor();
        Visitor imageFilterVisitor = new ImageFilterVisitor();

        System.out.println("使用高亮访问者：");
        document.accept(highlightVisitor);

        System.out.println("\n使用图片滤镜访问者：");
        document.accept(imageFilterVisitor);
    }
}
