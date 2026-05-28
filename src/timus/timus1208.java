package timus;

import java.util.*;

public class timus1208 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String[][] a = new String[k][3];
        for (int i = 0; i < k; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = sc.next();
        int ans = 0;
        for (int mask = 0; mask < (1 << k); mask++) {
            HashSet<String> set = new HashSet<>();
            boolean ok = true;
            int cnt = 0;

            for (int i = 0; i < k && ok; i++) {
                if ((mask & (1 << i)) == 0) continue;
                cnt++;
                for (int j = 0; j < 3; j++) {
                    if (set.contains(a[i][j])) {
                        ok = false;
                        break;
                    }
                    set.add(a[i][j]);
                }
            }
            if (ok) ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
