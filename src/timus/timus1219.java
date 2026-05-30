package timus;

import java.io.*;

public class timus1219 {
    static int[] seq;
    static int[] a;
    static int K = 26, N = 3;

    public static void main(String[] args) throws IOException {
        seq = new int[K * K * K];
        a = new int[K * N + 1];
        int[] len = {0};
        db(1, 1, len);

        byte[] out = new byte[1_000_000];
        int seqLen = len[0];
        for (int i = 0; i < 1_000_000; i++) {
            out[i] = (byte) ('a' + seq[i % seqLen]);
        }
        System.out.write(out);
        System.out.flush();
    }

    static void db(int t, int p, int[] len) {
        if (t > N) {
            if (N % p == 0) {
                for (int i = 1; i <= p; i++) {
                    seq[len[0]++] = a[i];
                }
            }
        } else {
            a[t] = a[t - p];
            db(t + 1, p, len);
            for (int j = a[t - p] + 1; j < K; j++) {
                a[t] = j;
                db(t + 1, t, len);
            }
        }
    }
}
