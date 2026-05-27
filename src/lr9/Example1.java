package lr9;

public class Example1 {


    static void example1(int x) {
        if (x >= 0 && x < 20) {
            System.out.print(x + " ");
            example1(2 * x + 1);
        }
    }

    static void example2(int x) {
        if (x >= 0 && x < 20) {
            example2(2 * x + 1);
            System.out.print(x + " ");
        }
    }

    static void example3(int x) {
        if (x >= 0 && x < 20) {
            System.out.print("вход: " + x + "  ");
            example3(2 * x + 1);
            System.out.print("выход: " + x + "  ");
        }
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return factorial(n - 1) * n;
    }

    static long fib(int n, int depth) {

        System.out.println("  ".repeat(depth) + "fib(" + n + ")");
        if (n <= 1) return n;
        return fib(n - 1, depth + 1) + fib(n - 2, depth + 1);
    }

    public static void main(String[] args) {
        System.out.println("Пример 1. Прямой порядок (x = 2x+1):");
        example1(1);
        System.out.println("\n");

        System.out.println("Пример 2. Обратный порядок:");
        example2(1);
        System.out.println("\n");

        System.out.println("Пример 3. Параметр до и после рекурсивного вызова:");
        example3(1);
        System.out.println("\n");

        System.out.println("Пример 4. Факториал:");
        for (int n = 1; n <= 7; n++) {
            System.out.println(n + "! = " + factorial(n));
        }
        System.out.println();

        System.out.println("Пример 5. Число Фибоначчи по номеру:");
        int num = 7;
        System.out.println("Дерево рекурсивных вызовов для fib(" + num + "):");
        long result = fib(num, 0);
        System.out.println("Результат: fib(" + num + ") = " + result);
    }
}
