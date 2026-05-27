package timus;
public class timus1600 {

    static final double EPS = 1e-9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double d = sc.nextDouble();
        double[][] a = new double[n][6];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 6; j++)
                a[i][j] = sc.nextDouble();
        double best = 1e100;
        int A = -1, B = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double rx = a[i][0] - a[j][0];
                double ry = a[i][1] - a[j][1];
                double rz = a[i][2] - a[j][2];
                double vx = a[i][3] - a[j][3];
                double vy = a[i][4] - a[j][4];
                double vz = a[i][5] - a[j][5];
                double aa = vx * vx + vy * vy + vz * vz;
                double bb = 2 * (rx * vx + ry * vy + rz * vz);
                double cc = rx * rx + ry * ry + rz * rz - d * d;
                if (aa < EPS) continue;
                double D = bb * bb - 4 * aa * cc;
                if (D < -EPS) continue;
                if (D < 0) D = 0;
                double s = Math.sqrt(D);
                double t1 = (-bb - s) / (2 * aa);
                double t2 = (-bb + s) / (2 * aa);
                double t = 1e100;
                if (t1 >= -EPS) t = Math.max(0, t1);
                else if (t2 >= -EPS) t = Math.max(0, t2);
                if (t < best) {
                    best = t;
                    A = i + 1;
                    B = j + 1;
                }
            }
        }
        if (A == -1) {
            System.out.println("OK");
        } else {
            System.out.println("ALARM!");
            System.out.printf(Locale.US, "%.3f %d %d\n", best, A, B);
        }
    }
}
