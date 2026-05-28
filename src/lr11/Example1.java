package lr11;

import java.util.*;
import java.util.stream.*;

public class Example1 {

    static int[] filterEven(int[] arr) {
        return Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    static int[] commonElements(int[] a, int[] b) {
        Set<Integer> setB = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(a)
                .filter(n -> setB.contains(n))
                .toArray();
    }

    static List<String> filterUpperCase(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    static List<String> filterBySubstring(List<String> list, String sub) {
        return list.stream()
                .filter(s -> s.contains(sub))
                .collect(Collectors.toList());
    }

    static List<Integer> filterDivisible(List<Integer> list, int divisor) {
        return list.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    static List<String> filterByLength(List<String> list, int minLen) {
        return list.stream()
                .filter(s -> s.length() > minLen)
                .collect(Collectors.toList());
    }

    static List<Integer> filterGreaterThan(List<Integer> list, int value) {
        return list.stream()
                .filter(n -> n > value)
                .collect(Collectors.toList());
    }

    static List<String> filterLettersOnly(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+"))
                .collect(Collectors.toList());
    }

    static List<Integer> filterLessThan(List<Integer> list, int value) {
        return list.stream()
                .filter(n -> n < value)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("1. Чётные числа: " +
            Arrays.toString(filterEven(new int[]{1, 2, 3, 4, 5, 6})));

        System.out.println("2. Общие элементы: " +
            Arrays.toString(commonElements(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6})));

        System.out.println("3. Строки с заглавной буквы: " +
            filterUpperCase(Arrays.asList("Java", "python", "C++", "kotlin")));

        System.out.println("4. Квадраты чисел: " +
            squareNumbers(Arrays.asList(1, 2, 3, 4, 5)));

        System.out.println("5. Строки с подстрокой 'av': " +
            filterBySubstring(Arrays.asList("Java", "Python", "JavaScript", "C"), "av"));

        System.out.println("6. Числа делящиеся на 3: " +
            filterDivisible(Arrays.asList(1, 3, 6, 7, 9, 10, 12), 3));

        System.out.println("7. Строки длиннее 4 символов: " +
            filterByLength(Arrays.asList("Java", "C++", "Python", "Go"), 4));

        System.out.println("8. Числа больше 5: " +
            filterGreaterThan(Arrays.asList(1, 4, 6, 8, 3, 10), 5));

        System.out.println("9. Строки только из букв: " +
            filterLettersOnly(Arrays.asList("Hello", "World2", "Java", "C++", "Python")));

        System.out.println("10. Числа меньше 5: " +
            filterLessThan(Arrays.asList(1, 4, 6, 8, 3, 10), 5));
    }
}
