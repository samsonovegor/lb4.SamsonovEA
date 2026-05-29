package timus;

import java.util.*;

public class timus1096 {

    static class Edge {
        int to, id;
        Edge(int t, int i) {
            to = t;
            id = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Edge>[] g = new ArrayList[2001];
        for (int i = 0; i <= 2000; i++)
            g[i] = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(new Edge(b, i));
        }
        int T = sc.nextInt();
        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int[] prev = new int[2001];
        int[] bus = new int[2001];
        Arrays.fill(prev, -1);
        Queue<Integer> q = new ArrayDeque<>();
        prev[S1] = S1;
        prev[S2] = S2;
        q.add(S1);
        if (S1 != S2)
            q.add(S2);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge e : g[v]) {
                if (prev[e.to] != -1) continue;
                prev[e.to] = v;
                bus[e.to] = e.id;
                q.add(e.to);
            }
        }
        if (prev[T] == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int cur = T;
        while (cur != S1 && cur != S2) {
            ans.add(bus[cur]);
            cur = prev[cur];
        }
        Collections.reverse(ans);
        System.out.println(ans.size());
        for (int x : ans)
            System.out.println(x);
    }
}