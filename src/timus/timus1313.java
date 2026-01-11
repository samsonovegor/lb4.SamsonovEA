package timus;

import java.util.Scanner;

public class timus1313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int s = 0; s <= 2 * (N - 1); s++) {
            for (int i = N - 1; i >= 0; i--) {
                int j = s - i;
                if (j >= 0 && j < N) {
                    sb.append(a[i][j]).append(" ");
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
