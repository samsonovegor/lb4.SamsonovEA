package lr7;

class A {
    public int x;

    A(int x) {
        this.x = x;
    }

    void set(int x) {
        this.x = x;
    }

    public String toString() {
        return "A: x=" + x;
    }
}

class B extends A {
    public char c;

    B(int x, char c) {
        super(x);
        this.c = c;
    }

    void set(int x, char c) {
        this.x = x;
        this.c = c;
    }

    public String toString() {
        return "B: x=" + x + ", c=" + c;
    }
}

public class Example3 extends B {
    public String text;

    Example3(int x, char c, String text) {
        super(x, c);
        this.text = text;
    }

    void set(int x, char c, String text) {
        this.x = x;
        this.c = c;
        this.text = text;
    }

    public String toString() {
        return "Example3: x=" + x + ", c=" + c + ", text=" + text;
    }
}
