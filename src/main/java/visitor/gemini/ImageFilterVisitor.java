package visitor.gemini;

public class ImageFilterVisitor implements Visitor {
    @Override
    public void visit(DocumentElement element) {
        if (element instanceof ImageSegment) {
            ImageSegment imageSegment = (ImageSegment) element;
            System.out.println("应用滤镜到图片: " + imageSegment.getImageName());
            // 实际应用滤镜的操作...
        }
    }
}
