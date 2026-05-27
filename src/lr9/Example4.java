package lr9;

public class Example4 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    static void print(Node head) {
        Node ref = head;
        StringBuilder sb = new StringBuilder();
        while (ref != null) {
            sb.append(ref.value);
            if (ref.next != null) sb.append(" -> ");
            ref = ref.next;
        }
        System.out.println(sb);
    }
    static Node createFromHead(int count) {
        Node head = new Node(1, null);
        Node ref = head;
        for (int i = 2; i <= count; i++) {
            ref.next = new Node(i, null);
            ref = ref.next;
        }
        return head;
    }
    static Node createFromTail(int count) {
        Node head = new Node(count, null);
        for (int i = count - 1; i >= 1; i--) {
            head = new Node(i, head);
        }
        return head;
    }
    public static void main(String[] args) {
        System.out.println("Способ 1: построение с головы:");
        Node list1 = createFromHead(7);
        print(list1);

        System.out.println("Способ 2: построение с хвоста:");
        Node list2 = createFromTail(7);
        print(list2);
    }
}
