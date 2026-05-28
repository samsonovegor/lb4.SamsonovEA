package timus;

import java.util.*;

public class timus1204 {

    static long modPow(long a, long e, long mod) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1)
                r = (r * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long n = sc.nextLong();
            long p = 0, q = 0;
            for (long i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    p = i;
                    q = n / i;
                    break;
                }
            }
            long invQ = modPow(q, p - 2, p);
            long invP = modPow(p, q - 2, q);
            long x1 = (q * invQ) % n;
            long x2 = (p * invP) % n;
            long[] ans = {0, 1, x1, x2};
            Arrays.sort(ans);
            System.out.println(
                    ans[0] + " " +
                            ans[1] + " " +
                            ans[2] + " " +
                            ans[3]
            );
        }
    }
}
