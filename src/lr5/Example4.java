package lr5;

public class Example4 {

    char ch;
    int num;
    Example4(int n, char c) {
        num = n;
        ch = c;
    }
    Example4(double d) {
        ch = (char) ((int) d);
        num = (int) ((d - (int) d) * 100);
    }
}
