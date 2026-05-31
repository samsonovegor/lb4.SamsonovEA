package timus;

import java.util.*;
        import java.io.*;

public class timus1121 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dist = new int[h][w];
        int[][] types = new int[h][w];
        for (int[] row : dist) Arrays.fill(row, -1);
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] != 0) {
                    dist[i][j] = 0;
                    types[i][j] = grid[i][j];
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];
            for (int[] d : dirs) {
                int ni = ci + d[0], nj = cj + d[1];
                if (ni < 0 || ni >= h || nj < 0 || nj >= w) continue;
                if (dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[ci][cj] + 1;
                    types[ni][nj] = types[ci][cj];
                    q.add(new int[]{ni, nj});
                } else if (dist[ni][nj] == dist[ci][cj] + 1) {
                    types[ni][nj] |= types[ci][cj];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j > 0) sb.append(' ');
                if (grid[i][j] != 0) {
                    sb.append(-1);
                } else if (dist[i][j] == -1 || dist[i][j] > 5) {
                    sb.append(0);
                } else {
                    sb.append(types[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
