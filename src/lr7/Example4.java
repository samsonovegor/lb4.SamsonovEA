package lr7;

class A4 {
    public char c;
    A4(char c) {
        this.c = c;
    }
    A4(A4 obj) {
        this.c = obj.c;
    }
}

class B4 extends A4 {
    public String text;
    B4(char c, String text) {
        super(c);
        this.text = text;
    }
    B4(B4 obj) {
        super(obj);
        this.text = obj.text;
    }
}

public class Example4 extends B4 {
    public int x;
    Example4(char c, String text, int x) {
        super(c, text);
        this.x = x;
    }
    Example4(Example4 obj) {
        super(obj);
        this.x = obj.x;
    }
}
