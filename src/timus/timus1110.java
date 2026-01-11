package timus;

import java.util.Scanner;

public class timus1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Y = sc.nextInt();
        boolean found = false;

        for (int X = 0; X < M; X++) {
            int res = 1;
            for (int i = 0; i < N; i++) {
                res = (res * X) % M;
            }
            if (res == Y) {
                if (found) System.out.print(" ");
                System.out.print(X);
                found = true;
            }
        }

        if (!found) System.out.println("-1");
        else System.out.println();
    }
}
