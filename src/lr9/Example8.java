package lr9;

import java.util.Scanner;

public class Example8 {

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) { this.value = value; this.next = next; }
    }

    private Node head;

    public void createHead(int[] values) {
        head = null;
        Node tail = null;
        for (int v : values) {
            Node node = new Node(v, null);
            if (head == null) { head = node; tail = node; }
            else { tail.next = node; tail = node; }
        }
    }

    public void createTail(int[] values) {
        head = null;
        for (int v : values) {
            head = new Node(v, head);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value);
            if (ref.next != null) sb.append(", ");
            ref = ref.next;
        }
        return sb.append("]").toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        Node node = new Node(value, null);
        if (head == null) { head = node; return; }
        Node ref = head;
        while (ref.next != null) ref = ref.next;
        ref.next = node;
    }

    public void insert(int index, int value) {
        if (index <= 0 || head == null) { addFirst(value); return; }
        Node ref = head;
        int k = 0;
        while (ref.next != null && k < index - 1) { ref = ref.next; k++; }
        ref.next = new Node(value, ref.next);
    }

    public void removeFirst() {
        if (head != null) head = head.next;
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) { head = null; return; }
        Node ref = head;
        while (ref.next.next != null) ref = ref.next;
        ref.next = null;
    }

    public void remove(int index) {
        if (head == null) return;
        if (index <= 0) { removeFirst(); return; }
        Node ref = head;
        int k = 0;
        while (ref.next != null && k < index - 1) { ref = ref.next; k++; }
        if (ref.next != null) ref.next = ref.next.next;
    }

    public void createHeadRec(int[] values) {
        head = buildHeadRec(values, 0);
    }
    private Node buildHeadRec(int[] values, int i) {
        if (i == values.length) return null;
        return new Node(values[i], buildHeadRec(values, i + 1));
    }

    public void createTailRec(int[] values) {
        head = buildTailRec(values, 0, null);
    }
    private Node buildTailRec(int[] values, int i, Node acc) {
        if (i == values.length) return acc;
        return buildTailRec(values, i + 1, new Node(values[i], acc));
    }

    public String toStringRec() {
        return "[" + buildStringRec(head) + "]";
    }
    private String buildStringRec(Node node) {
        if (node == null) return "";
        if (node.next == null) return String.valueOf(node.value);
        return node.value + ", " + buildStringRec(node.next);
    }

    public static void main(String[] args) {
        Example8 list = new Example8();
        int[] data = {1, 2, 3, 4, 5};

        System.out.println("createHead([1,2,3,4,5]):      " + listAfterCreateHead(data));
        System.out.println("createTail([1,2,3,4,5]):      " + listAfterCreateTail(data));

        list.createHead(data);
        list.addFirst(0);
        System.out.println("addFirst(0):                  " + list);
        list.addLast(6);
        System.out.println("addLast(6):                   " + list);
        list.insert(3, 99);
        System.out.println("insert(3, 99):                " + list);
        list.removeFirst();
        System.out.println("removeFirst():                " + list);
        list.removeLast();
        System.out.println("removeLast():                 " + list);
        list.remove(3);
        System.out.println("remove(3):                    " + list);

        System.out.println();
        Example8 r = new Example8();
        r.createHeadRec(data);
        System.out.println("createHeadRec + toStringRec:  " + r.toStringRec());
        r.createTailRec(data);
        System.out.println("createTailRec + toStringRec:  " + r.toStringRec());
    }

    private static String listAfterCreateHead(int[] d) {
        Example8 l = new Example8(); l.createHead(d); return l.toString();
    }
    private static String listAfterCreateTail(int[] d) {
        Example8 l = new Example8(); l.createTail(d); return l.toString();
    }
}
