package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    static int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    public static void main(String[] args) {
        System.out.println("Матрица:");
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер столбца (0-" + (matrix[0].length - 1) + "): ");

        try {
            int col = scanner.nextInt();
            printColumn(col);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите число, а не строку");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: нет столбца с таким номером. Допустимо: 0-" +
                (matrix[0].length - 1));
        }

        scanner.close();
    }

    static void printColumn(int col) {
        System.out.println("Столбец " + col + ":");
        for (int[] row : matrix) {
            System.out.println(row[col]);
        }
    }
}
