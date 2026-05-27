package lr9;

import java.util.Scanner;

public class Example3 {

    static Scanner sc = new Scanner(System.in);


    static void inputArray(int[] a, int i) {
        if (i == a.length) return;
        System.out.print("a[" + i + "] = ");
        a[i] = sc.nextInt();
        inputArray(a, i + 1);
    }


    static void printArray(int[] a, int i) {
        if (i == a.length) {
            System.out.println();
            return;
        }
        System.out.print(a[i] + " ");
        printArray(a, i + 1);
    }

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Ввод элементов:");
        inputArray(a, 0);

        System.out.println("Содержимое массива:");
        printArray(a, 0);
    }
}
