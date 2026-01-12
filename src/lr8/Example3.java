package lr8;

import java.io.*;

public class Example3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("text.txt"), "cp1251"));

        PrintWriter out = new PrintWriter("result.txt", "cp1251");

        String line;
        int lineNum = 0;
        String consonants = "бвгджзйклмнпрстфхцчшщ";

        while ((line = br.readLine()) != null) {
            lineNum++;
            String[] words = line.split("\\s+");
            int count = 0;

            for (String w : words) {
                if (!w.isEmpty() &&
                        consonants.indexOf(Character.toLowerCase(w.charAt(0))) >= 0) {
                    out.println("Строка " + lineNum + ": " + w);
                    count++;
                }
            }
            out.println("Найдено слов: " + count);
        }

        br.close();
        out.close();
    }
}
