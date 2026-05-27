package lr9;

import java.util.*;

public class Example7 {

    static int josephus(List<Integer> circle) {
        int idx = 0;

        while (circle.size() > 1) {
            idx = (idx + 1) % circle.size();
            circle.remove(idx);

            if (idx == circle.size()) idx = 0;
        }
        return circle.get(0);
    }

    static List<Integer> build(List<Integer> list, int n) {
        for (int i = 1; i <= n; i++) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        int n = 100_000;


        List<Integer> arr = build(new ArrayList<>(), n);
        long t1 = System.nanoTime();
        int survivorArr = josephus(arr);
        long t2 = System.nanoTime();


        List<Integer> lnk = build(new LinkedList<>(), n);
        long t3 = System.nanoTime();
        int survivorLnk = josephus(lnk);
        long t4 = System.nanoTime();

        System.out.println("N = " + n);
        System.out.println("Выживший (ArrayList)  = " + survivorArr
                + ",  время = " + (t2 - t1) / 1_000_000 + " мс");
        System.out.println("Выживший (LinkedList) = " + survivorLnk
                + ",  время = " + (t4 - t3) / 1_000_000 + " мс");

        System.out.println();
        System.out.println("Демонстрация для N = 10:");
        System.out.println("Выживший = " + josephus(build(new ArrayList<>(), 10)));
    }
}
