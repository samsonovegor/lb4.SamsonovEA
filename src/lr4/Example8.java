package lr4;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст для шифрования:");
        String text = in.nextLine();
        System.out.println("Введите ключ:");
        int key = in.nextInt();
        in.nextLine();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }
        String encrypted = new String(chars);
        System.out.println("Текст после преобразования: " + encrypted);
        System.out.println("Выполнить обратное преобразование? (y/n)");
        String ans = in.nextLine();
        if (ans.equals("y")) {
            char[] back = encrypted.toCharArray();
            for (int i = 0; i < back.length; i++) {
                back[i] = (char) (back[i] - key);
            }
            System.out.println(new String(back));
        } else if (ans.equals("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }
        in.close();
    }
}
