package timus;

import java.util.*;

public class timus1496 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            cnt.put(name, cnt.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println(e.getKey());
            }
        }
    }
}
