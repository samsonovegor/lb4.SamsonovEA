import java.io.*;
        import java.util.*;

public class timus1130 {

    static class Node {
        long x, y;
        int left = -1;
        int right = -1;
        int signRight = 1; // +1 или -1
        int id;
        Node(long x, long y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
        Node(long x, long y, int left, int right, int signRight) {
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
            this.signRight = signRight;
        }
    }
    static ArrayList<Node> nodes = new ArrayList<>();
    static char[] ans;

    static long norm2(long x, long y) {
        return x * x + y * y;
    }
    static void dfs(int v, int sign) {
        Node cur = nodes.get(v);

        if (cur.left == -1) {
            ans[cur.id] = (sign == 1 ? '+' : '-');
            return;
        }
        dfs(cur.left, sign);
        dfs(cur.right, sign * cur.signRight);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long L = Long.parseLong(br.readLine());
        ArrayList<Integer> alive = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            nodes.add(new Node(x, y, i));
            alive.add(nodes.size() - 1);
            while (alive.size() >= 3) {
                int a = alive.get(alive.size() - 3);
                int b = alive.get(alive.size() - 2);
                int c = alive.get(alive.size() - 1);
                int[] ids = {a, b, c};
                boolean merged = false;
                for (int i1 = 0; i1 < 3 && !merged; i1++) {
                    for (int i2 = i1 + 1; i2 < 3 && !merged; i2++) {
                        int u = ids[i1];
                        int v = ids[i2];
                        Node A = nodes.get(u);
                        Node B = nodes.get(v);
                        long sx = A.x + B.x;
                        long sy = A.y + B.y;
                        if (norm2(sx, sy) <= L * L) {
                            Node nw = new Node(sx, sy, u, v, 1);
                            nodes.add(nw);
                            int keep = ids[3 - i1 - i2];
                            alive.remove(alive.size() - 1);
                            alive.remove(alive.size() - 1);
                            alive.remove(alive.size() - 1);
                            alive.add(keep);
                            alive.add(nodes.size() - 1);
                            merged = true;
                            break;
                        }
                        sx = A.x - B.x;
                        sy = A.y - B.y;
                        if (norm2(sx, sy) <= L * L) {
                            Node nw = new Node(sx, sy, u, v, -1);
                            nodes.add(nw);
                            int keep = ids[3 - i1 - i2];
                            alive.remove(alive.size() - 1);
                            alive.remove(alive.size() - 1);
                            alive.remove(alive.size() - 1);
                            alive.add(keep);
                            alive.add(nodes.size() - 1);
                            merged = true;
                        }
                    }
                }
            }
        }
        int root;
        if (alive.size() == 1) {
            root = alive.get(0);
        } else {
            int a = alive.get(0);
            int b = alive.get(1);
            Node A = nodes.get(a);
            Node B = nodes.get(b);
            long plus = norm2(A.x + B.x, A.y + B.y);
            long minus = norm2(A.x - B.x, A.y - B.y);
            if (plus <= minus) {
                nodes.add(new Node(A.x + B.x, A.y + B.y, a, b, 1));
            } else {
                nodes.add(new Node(A.x - B.x, A.y - B.y, a, b, -1));
            }
            root = nodes.size() - 1;
        }
        ans = new char[n];
        dfs(root, 1);
        System.out.println("YES");
        System.out.println(new String(ans));
    }
}