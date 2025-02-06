package chain.qwen;

public class Request {

    private String content;
    private double amount;

    public Request(String content, double amount) {
        this.content = content;
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public double getAmount() {
        return amount;
    }
}
