package lr7;

class Super1 {
    private String text;

    Super1(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Super1: text=" + text;
    }
}

public class Example1 extends Super1 {
    private String text2;

    Example1(String text) {
        super(text);
    }

    Example1(String text, String text2) {
        super(text);
        this.text2 = text2;
    }

    @Override
    public String toString() {
        return "Example1: " + super.toString() + ", text2=" + text2;
    }
}
