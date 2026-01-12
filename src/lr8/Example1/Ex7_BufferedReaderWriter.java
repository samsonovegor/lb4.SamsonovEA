package lr8.Example1;

import java.io.*;

public class Ex7_BufferedReaderWriter {
    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new FileReader("E:\\MyFile1.txt"));

        BufferedWriter bw =
                new BufferedWriter(new FileWriter("E:\\MyFile2.txt"));

        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
