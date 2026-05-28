package timus;

import java.util.*;

public class timus1200 {

    static double f(double A, double B, int x, int y) {
        return A * x + B * y - x * x - y * y;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double A = sc.nextDouble();
        double B = sc.nextDouble();
        int K = sc.nextInt();
        double best = -1e100;
        int bx = 0, by = 0;
        for (int x = 0; x <= K; x++) {
            int lim = K - x;
            ArrayList<Integer> cand = new ArrayList<>();
            cand.add(0);
            cand.add(lim);
            int y0 = (int)Math.floor(B / 2.0);
            for (int y = y0 - 3; y <= y0 + 3; y++)
                cand.add(y);
            for (int y : cand) {
                if (y < 0 || y > lim) continue;
                double cur = f(A, B, x, y);
                if (cur > best + 1e-9 ||
                        (Math.abs(cur - best) < 1e-9 &&
                                (x < bx || (x == bx && y < by)))) {
                    best = cur;
                    bx = x;
                    by = y;
                }
            }
        }
        System.out.printf(Locale.US, "%.2f\n", best);
        System.out.println(bx + " " + by);
    }
}
