package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        System.out.println("Введите 5 целых чисел:");
        for (int i = 0; i < array.length; i++) {
            while (true) {
                try {
                    System.out.print("array[" + i + "] = ");
                    array[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число, а не строку");
                    scanner.nextLine();
                }
            }
        }

        try {
            System.out.println("Среднее положительных: " + avgPositive(array));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    static double avgPositive(int[] array) {
        int sum = 0;
        int count = 0;
        for (int n : array) {
            if (n > 0) {
                sum += n;
                count++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException("Положительные элементы отсутствуют");
        }
        return (double) sum / count;
    }
}
