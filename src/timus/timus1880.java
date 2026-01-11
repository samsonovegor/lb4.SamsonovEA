package timus;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class timus1880 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set.add(sc.nextInt());
        }

        int n2 = sc.nextInt();
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            int x = sc.nextInt();
            if (set.contains(x)) temp.add(x);
        }
        set = temp;

        int n3 = sc.nextInt();
        temp = new HashSet<>();
        for (int i = 0; i < n3; i++) {
            int x = sc.nextInt();
            if (set.contains(x)) temp.add(x);
        }
        set = temp;

        System.out.println(set.size());
    }
}
