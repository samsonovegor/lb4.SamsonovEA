package timus;

import java.util.Scanner;

public class timus1493 {

    static boolean isLucky(int x) {
        String s = String.format("%06d", x);
        int left = 0, right = 0;
        for (int i = 0; i < 3; i++) {
            left += s.charAt(i) - '0';
            right += s.charAt(i + 3) - '0';
        }
        return left == right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int n = Integer.parseInt(input);

        boolean ok = false;
        if (n > 0 && isLucky(n - 1)) {
            ok = true;
        }
        if (n < 999999 && isLucky(n + 1)) {
            ok = true;
        }

        System.out.println(ok ? "Yes" : "No");
    }
}
