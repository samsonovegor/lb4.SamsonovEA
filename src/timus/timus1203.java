import java.util.*;

public class timus1203 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, (x, y) -> x[1] - y[1]);

        int ans = 0;
        int last = -1;

        for (int[] p : a) {

            if (p[0] > last) {
                ans++;
                last = p[1];
            }
        }

        System.out.println(ans);
    }
}
