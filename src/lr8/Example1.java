package lr8;

import java.io.*;

public class Example1 {
    public static void main(String[] args) {

        try {
            //Работа с File
            File file = new File("text.txt");
            file.createNewFile();

            //Запись текста
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Пример строки с кириллицей");
            writer.newLine();
            writer.write("Вторая строка текста");
            writer.close();

            //Пример 7 BufferedReader / BufferedWriter
            //без указания кодировки

            BufferedReader br7 = new BufferedReader(
                    new FileReader("text.txt"));
            BufferedWriter bw7 = new BufferedWriter(
                    new FileWriter("out7.txt"));

            String line;
            while ((line = br7.readLine()) != null) {
                bw7.write(line);
                bw7.newLine();
            }

            br7.close();
            bw7.close();

            //Пример 8 InputStreamReader / OutputStreamWriter
            //указанием кодировки UTF-8
            BufferedReader br8 = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("text.txt"), "UTF-8"));
            BufferedWriter bw8 = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("out8.txt"), "UTF-8"));

            while ((line = br8.readLine()) != null) {
                bw8.write(line);
                bw8.newLine();
            }

            br8.close();
            bw8.close();

            //PrintWriter
            PrintWriter out = new PrintWriter(System.out);
            out.println("Задание 1 выполнено");
            out.flush();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
