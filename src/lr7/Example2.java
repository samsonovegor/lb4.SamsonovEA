package lr7;

class Super2 {
    private String text;

    Super2(String text) {
        this.text = text;
    }

    void setText(String text) {
        this.text = text;
    }

    int length() {
        return text.length();
    }

    protected String getText() {
        return text;
    }
}

public class Example2 extends Super2 {
    public int number;

    Example2(int number, String text) {
        super(text);
        this.number = number;
    }

    void setText() {
        setText("");
        number = 0;
    }

    void setText(String text) {
        super.setText(text);
    }

    void setText(int number) {
        this.number = number;
    }

    void setText(String text, int number) {
        super.setText(text);
        this.number = number;
    }
}
