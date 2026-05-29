package timus;

import java.util.*;

public class timus1113 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double N = sc.nextInt();
        double M = sc.nextInt();
        double dist = 0;
        double fuel = 0;
        int k = 1;
        while (dist + M / (2 * k - 1) < N) {
            dist += M / (2 * k - 1);
            fuel += M;
            k++;
        }
        fuel += (N - dist) * (2 * k - 1);

        System.out.println((long)Math.ceil(fuel));
    }
}
