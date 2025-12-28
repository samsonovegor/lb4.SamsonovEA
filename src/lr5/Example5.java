package lr5;

public class Example5 {

    private int value;
    Example5() {
        value = 0;
    }
    Example5(int v) {
        setValue(v);
    }
    public void setValue() {
        value = 0;
    }
    public void setValue(int v) {
        value = v > 100 ? 100 : v;
    }
    public int getValue() {
        return value;
    }
}
