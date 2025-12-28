package lr5;

public class Example1 {

    private char ch;

    public void setChar(char c) {
        ch = c;
    }

    public int getCode() {
        return ch;
    }

    public void show() {
        System.out.println(ch + " " + (int) ch);
    }
}
