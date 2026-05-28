package timus;

import java.io.*;
        import java.util.*;

public class timus1207 {

    static class Point {
        int x, y, id;

        Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] p = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y, i + 1);
        }

        int left = 0;
        for (int i = 1; i < n; i++) {
            if (p[i].x < p[left].x ||
                    (p[i].x == p[left].x && p[i].y < p[left].y)) {
                left = i;
            }
        }
        Point base = p[left];
        ArrayList<Point> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != left) a.add(p[i]);
        }
        Collections.sort(a, (u, v) -> {
            long cross =
                    (long)(u.x - base.x) * (v.y - base.y) -
                            (long)(u.y - base.y) * (v.x - base.x);

            return cross > 0 ? -1 : 1;
        });

        System.out.println(base.id + " " + a.get((n - 2) / 2).id);
    }
}