package timus;

import java.util.Scanner;

public class timus1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        for (int t = 0; t < N; t++) {
            String pos = sc.nextLine();
            int x = pos.charAt(0) - 'a';
            int y = pos.charAt(1) - '1';
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) count++;
            }
            System.out.println(count);
        }
    }
}
