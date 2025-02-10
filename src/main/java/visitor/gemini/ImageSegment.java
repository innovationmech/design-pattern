package visitor.gemini;

public class ImageSegment implements DocumentElement {

    private String imageName;

    public ImageSegment(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
