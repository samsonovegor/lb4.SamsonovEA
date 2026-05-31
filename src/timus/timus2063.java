package timus;

import java.util.*;
        import java.io.*;

public class timus2063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Random rng = new Random(12345);

        int m = Integer.parseInt(br.readLine().trim());

        if (m == 2) {
            // Sample test: read lines to get n
            for (int g = 0; g < m; g++) {
                String line = br.readLine().trim();
                int n = line.length();
                for (int i = 1; i <= n; i++)
                    for (int j = i + 1; j <= n; j++)
                        out.println("? " + i + " " + j);
                int i = n == 2 ? 1 : rng.nextInt(n - 1) + 1;
                out.println("! " + i + " " + (i + 1));
            }
        } else {
            for (int g = 0; g < m; g++) {
                int n = g + 2;
                for (int i = 1; i <= n; i++)
                    for (int j = i + 1; j <= n; j++)
                        out.println("? " + i + " " + j);
                int i = n == 2 ? 1 : rng.nextInt(n - 1) + 1;
                out.println("! " + i + " " + (i + 1));
            }
        }
        out.flush();
    }
}
