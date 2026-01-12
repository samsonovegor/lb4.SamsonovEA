package lr7;

class Super5 {
    private String text;
    Super5(String text) {
        this.text = text;
    }
    void show() {
        System.out.println("Super5: text=" + text);
    }
    protected String getText() {
        return text;
    }
}

class Sub5A extends Super5 {
    protected int x;
    Sub5A(String text, int x) {
        super(text);
        this.x = x;
    }
    @Override
    void show() {
        System.out.println("Sub5A: text=" + getText() + ", x=" + x);
    }
}

public class Example5 extends Super5 {
    protected char c;
    Example5(String text, char c) {
        super(text);
        this.c = c;
    }
    @Override
    void show() {
        System.out.println("Example5: text=" + getText() + ", c=" + c);
    }
}
