package lr8.Example1;

import java.io.*;

public class Ex9_BufferedWithEncoding {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("E:\\MyFile1.txt"), "cp1251"));

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("E:\\MyFile2.txt"), "cp1251"));

        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
