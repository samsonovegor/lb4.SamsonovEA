package lr3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел Фибоначчи:");
        int n = in.nextInt();

        int a = 1, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int next = a + b;
            a = b;
            b = next;
        }

        in.close();
    }
}