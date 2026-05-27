package timus;

public class timus1512 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] pos = new int[n + 1];
        int idx = 1;
        int r = n % 6;

        if (r != 2 && r != 3) {
            for (int i = 2; i <= n; i += 2) pos[idx++] = i;
            for (int i = 1; i <= n; i += 2) pos[idx++] = i;
        } else if (r == 2) {
            for (int i = 2; i <= n; i += 2) pos[idx++] = i;
            pos[idx++] = 3;
            pos[idx++] = 1;
            for (int i = 7; i <= n - 1; i += 2) pos[idx++] = i;
            pos[idx++] = 5;
        } else {
            for (int i = 4; i <= n - 1; i += 2) pos[idx++] = i;
            pos[idx++] = 2;
            for (int i = 5; i <= n; i += 2) pos[idx++] = i;
            pos[idx++] = 1;
            pos[idx++] = 3;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(' ').append(pos[i]).append('\n');
        }
        System.out.print(sb);
    }
}
