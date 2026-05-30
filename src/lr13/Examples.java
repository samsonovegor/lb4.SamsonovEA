package lr13;

public class Examples {

    static void example1() {
        System.out.println(" Пример 1 ");
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) {
            System.out.println("1  " + e);
        }
        System.out.println("2");
    }

    static void example2() {
        System.out.println(" Пример 2 (исправлен: убрана недостижимая строка) ");
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }

    static void example3() {
        System.out.println(" Пример 3 ");
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
        }
        System.out.println("4");
    }

    static void example4() {
        System.out.println(" Пример 4 ");
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        } catch (Error e) {
            System.out.println("3");
        }
        System.out.println("4");
    }

    static void example5() {
        System.out.println(" Пример 5 (исключение не перехвачено) ");
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }

    static void example6() {
        System.out.println(" Пример 6 (исправлен: правильный порядок catch) ");
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
        }
        System.out.println("4");
    }

    static void example7() {
        System.out.println(" Пример 7 ");
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            throw new ArithmeticException();
        }
    }

    static int m8() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }

    static void example8() {
        System.out.println(" Пример 8 ");
        System.out.println(m8());
    }

    static int m9() {
        try {
            System.out.println("0");
            return 55;
        } finally {
            System.out.println("1");
        }
    }

    static void example9() {
        System.out.println(" Пример 9 ");
        System.out.println(m9());
    }

    static int m10() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20;
        }
    }

    static void example10() {
        System.out.println(" Пример 10 ");
        System.out.println(m10());
    }

    static void example11() {
        System.out.println(" Пример 11 ");
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }

    static void m12(String str, double chislo) {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    static void example12() {
        System.out.println(" Пример 12 ");
        m12(null, 0.000001);
    }

    static void example13() {
        System.out.println(" Пример 13 ");
        String[] args = {};
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }

    static void m14(int x) throws ArithmeticException {
        int h = 10 / x;
    }

    static void example14() {
        System.out.println(" Пример 14 ");
        String[] args = {};
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m14(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        try { example5(); } catch (Exception e) { System.out.println("Пример 5: исключение не перехвачено: " + e); }
        example6();
        try { example7(); } catch (Exception e) { System.out.println("Пример 7: " + e); }
        try { example8(); } catch (Exception e) { System.out.println("Пример 8: " + e); }
        example9();
        example10();
        example11();
        try { example12(); } catch (Exception e) { System.out.println("Пример 12: " + e); }
        example13();
        example14();
    }
}
