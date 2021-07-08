package producerandconsumer.version1;

public class PCData {
    private final int intData;

    public PCData(int d) {
        this.intData = d;
    }

    public PCData(String d) {
        this.intData = Integer.parseInt(d);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString(){
        return "data:"+intData;
    }
}
