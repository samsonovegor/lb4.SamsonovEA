package timus;

import java.util.*;

public class timus1100 {

    static class Team {
        int id, m;
        Team(int id, int m) {
            this.id = id;
            this.m = m;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Team[] a = new Team[n];
        for (int i = 0; i < n; i++)
            a[i] = new Team(sc.nextInt(), sc.nextInt());
        Arrays.sort(a, (x, y) -> y.m - x.m);
        StringBuilder sb = new StringBuilder();
        for (Team t : a)
            sb.append(t.id).append(' ')
                    .append(t.m).append('\n');
        System.out.print(sb);
    }
}
