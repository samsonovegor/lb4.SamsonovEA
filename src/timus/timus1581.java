package timus;

import java.util.Scanner;

public class timus1581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int prev = sc.nextInt();
        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            if (x == prev) {
                cnt++;
            } else {
                sb.append(cnt).append(" ").append(prev).append(" ");
                prev = x;
                cnt = 1;
            }
        }

        sb.append(cnt).append(" ").append(prev);

        System.out.println(sb.toString());
    }
}
