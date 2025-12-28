package lr5;

public class Example2 {

    public char a;
    public char b;

    public void showRange() {
        char start = a < b ? a : b;
        char end = a < b ? b : a;

        for (char c = start; c <= end; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
