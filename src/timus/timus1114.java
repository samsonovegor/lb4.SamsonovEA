package timus;

import java.util.*;
        import java.math.*;

public class timus1114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(comb(a + n, n).multiply(comb(b + n, n)));
    }

    static BigInteger comb(int n, int k) {
        if (k > n) return BigInteger.ZERO;
        if (k > n - k) k = n - k;
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }
        return result;
    }
}
