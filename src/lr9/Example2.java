package lr9;

import java.util.Scanner;

public class Example2 {

    static String toBinary(int n) {
        if (n == 0) return "";
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        int n = sc.nextInt();

        String bin = (n == 0) ? "0" : toBinary(n);
        System.out.println("Число " + n + " в двоичной системе: " + bin);


        System.out.println("Проверка (Integer.toBinaryString): " + Integer.toBinaryString(n));
    }
}
