package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] array = new byte[5];

        System.out.println("Введите 5 чисел типа byte (от -128 до 127):");
        for (int i = 0; i < array.length; i++) {
            while (true) {
                try {
                    System.out.print("array[" + i + "] = ");
                    int value = scanner.nextInt();
                    if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                        throw new IllegalArgumentException(
                            "Значение " + value + " выходит за границы типа byte (-128..127)");
                    }
                    array[i] = (byte) value;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число, а не строку");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        try {
            int sum = sumBytes(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка переполнения: " + e.getMessage());
        }

        scanner.close();
    }

    static int sumBytes(byte[] array) {
        int sum = 0;
        for (byte b : array) {
            sum += b;
            if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                throw new IllegalArgumentException(
                    "Сумма " + sum + " выходит за границы типа byte");
            }
        }
        return sum;
    }
}
