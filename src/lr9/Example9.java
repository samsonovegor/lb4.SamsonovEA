package lr9;

import java.util.*;

public class Example9 {

    static final int N = 1_000_000;
    static final int K = 10_000;

    static long ms(long nanos) { return nanos / 1_000_000; }

    static void benchArrayList() {
        System.out.println("ArrayList:");
        long t;

        ArrayList<Integer> a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.add(0, 0);
        System.out.println("add начало : " + ms(System.nanoTime() - t) + " ms");

        a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.add(a.size() / 2, 0);
        System.out.println("add середина: " + ms(System.nanoTime() - t) + " ms");

        a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.add(0);
        System.out.println("add конец  : " + ms(System.nanoTime() - t) + " ms");

        a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.remove(0);
        System.out.println("rm начало  : " + ms(System.nanoTime() - t) + " ms");

        a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.remove(a.size() / 2);
        System.out.println("rm середина: " + ms(System.nanoTime() - t) + " ms");

        a = fillAL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) a.remove(a.size() - 1);
        System.out.println("rm конец   : " + ms(System.nanoTime() - t) + " ms");
    }

    static void benchLinkedList() {
        System.out.println("LinkedList:");
        long t;

        LinkedList<Integer> l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.addFirst(0);
        System.out.println("add начало : " + ms(System.nanoTime() - t) + " ms");

        l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.add(l.size() / 2, 0);
        System.out.println("add середина: " + ms(System.nanoTime() - t) + " ms");

        l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.addLast(0);
        System.out.println("add конец  : " + ms(System.nanoTime() - t) + " ms");

        l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.removeFirst();
        System.out.println("rm начало  : " + ms(System.nanoTime() - t) + " ms");

        l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.remove(l.size() / 2);
        System.out.println("rm середина: " + ms(System.nanoTime() - t) + " ms");

        l = fillLL();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) l.removeLast();
        System.out.println("rm конец   : " + ms(System.nanoTime() - t) + " ms");
    }

    static void benchArrayDeque() {
        System.out.println("ArrayDeque:");
        long t;

        ArrayDeque<Integer> d = fillAD();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) d.addFirst(0);
        System.out.println("add начало : " + ms(System.nanoTime() - t) + " ms");

        System.out.println("add середина: - (нет доступа по индексу)");

        d = fillAD();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) d.addLast(0);
        System.out.println("add конец  : " + ms(System.nanoTime() - t) + " ms");

        d = fillAD();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) d.removeFirst();
        System.out.println("rm начало  : " + ms(System.nanoTime() - t) + " ms");

        System.out.println("rm середина: - (нет доступа по индексу)");

        d = fillAD();
        t = System.nanoTime();
        for (int i = 0; i < K; i++) d.removeLast();
        System.out.println("rm конец   : " + ms(System.nanoTime() - t) + " ms");
    }

    static void benchGet() {
        System.out.println("Получение по индексу:");
        Random rnd = new Random(42);


        int GET_AL = 100_000_000;
        ArrayList<Integer> a = fillAL();
        long t = System.nanoTime();
        long sink = 0;
        for (int i = 0; i < GET_AL; i++) sink += a.get(rnd.nextInt(N));
        System.out.println("ArrayList  get x" + GET_AL + " : " + ms(System.nanoTime() - t) + " ms (sink=" + sink + ")");


        int GET_LL = 10_000;
        LinkedList<Integer> l = fillLL();
        t = System.nanoTime();
        sink = 0;
        for (int i = 0; i < GET_LL; i++) sink += l.get(rnd.nextInt(N));
        System.out.println("LinkedList get x" + GET_LL + " : " + ms(System.nanoTime() - t) + " ms (sink=" + sink + ")");

        System.out.println("ArrayDeque get : - (нет доступа по индексу)");
    }

    static ArrayList<Integer> fillAL() {
        ArrayList<Integer> a = new ArrayList<>(N + K);
        for (int i = 0; i < N; i++) a.add(i);
        return a;
    }
    static LinkedList<Integer> fillLL() {
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < N; i++) l.add(i);
        return l;
    }
    static ArrayDeque<Integer> fillAD() {
        ArrayDeque<Integer> d = new ArrayDeque<>(N + K);
        for (int i = 0; i < N; i++) d.addLast(i);
        return d;
    }

    public static void main(String[] args) {
        System.out.println("N = " + N + ", K (операций add/remove) = " + K);
        System.out.println();
        benchArrayList();
        System.out.println();
        benchLinkedList();
        System.out.println();
        benchArrayDeque();
        System.out.println();
        benchGet();
    }
}
