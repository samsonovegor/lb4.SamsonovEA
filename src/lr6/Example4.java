package lr6;

public class Example4 {

    static long doubleFactorial(int n) {
        long res = 1;
        for (int i = n; i > 0; i -= 2) {
            res *= i;
        }
        return res;
    }
}
