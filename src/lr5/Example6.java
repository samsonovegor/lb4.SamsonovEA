package lr5;

public class Example6 {

    private int min;
    private int max;
    Example6() {
        min = 0;
        max = 0;
    }
    Example6(int a) {
        min = a;
        max = a;
    }
    Example6(int a, int b) {
        min = Math.min(a, b);
        max = Math.max(a, b);
    }
    public void set(int a) {
        min = Math.min(min, a);
        max = Math.max(max, a);
    }
    public void set(int a, int b) {
        min = Math.min(Math.min(min, a), b);
        max = Math.max(Math.max(max, a), b);
    }
    public void show() {
        System.out.println("min = " + min + ", max = " + max);
    }
}

