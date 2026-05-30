package timus;

import java.util.*;

public class timus1451 {
    static double[] px = new double[3];
    static double[] py = new double[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            px[i] = sc.nextDouble();
            py[i] = sc.nextDouble();
        }

        double x = (px[0] + px[1] + px[2]) / 3;
        double y = (py[0] + py[1] + py[2]) / 3;

        double step = 1.0;
        while (step > 1e-9) {
            double best = total(x, y);
            double bx = x, by = y;
            boolean moved = false;
            double[][] dirs = {{step,0},{-step,0},{0,step},{0,-step}};
            for (double[] d : dirs) {
                double t = total(x + d[0], y + d[1]);
                if (t < best) {
                    best = t;
                    bx = x + d[0];
                    by = y + d[1];
                    moved = true;
                }
            }
            x = bx;
            y = by;
            if (!moved) step *= 0.5;
        }

        System.out.printf("%.8f %.8f%n", x, y);
    }

    static double total(double x, double y) {
        double s = 0;
        for (int i = 0; i < 3; i++) {
            double dx = x - px[i], dy = y - py[i];
            s += Math.sqrt(dx*dx + dy*dy);
        }
        return s;
    }
}
