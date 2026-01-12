package lr8.Example1;

import java.io.*;

public class Ex10_PrintWriter {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("E:\\MyFile1.txt"), "cp1251"));

        PrintWriter out =
                new PrintWriter("E:\\MyFile2.txt", "cp1251");

        String s;
        while ((s = br.readLine()) != null)
            out.println(s);

        br.close();
        out.close();
    }
}
