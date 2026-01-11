package lr8;

import java.io.*;

public class Example3 {
    public static void main(String[] args) {

        try {
            // ---------- Исходный файл ----------
            BufferedWriter bw =
                    new BufferedWriter(new FileWriter("poem.txt"));

            bw.write("Мороз и солнце день чудесный");
            bw.newLine();
            bw.write("Еще ты дремлешь друг прелестный");
            bw.close();

            // ---------- Обработка ----------
            BufferedReader br =
                    new BufferedReader(new FileReader("poem.txt"));
            BufferedWriter out =
                    new BufferedWriter(new FileWriter("words.txt"));

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                int count = 0;

                for (String word : words) {
                    if (word.matches("(?i)^[бвгджзйклмнпрстфхцчшщ].*")) {
                        out.write("Строка " + lineNumber + ": " + word);
                        out.newLine();
                        count++;
                    }
                }

                out.write("Количество слов: " + count);
                out.newLine();
                lineNumber++;
            }

            br.close();
            out.close();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
