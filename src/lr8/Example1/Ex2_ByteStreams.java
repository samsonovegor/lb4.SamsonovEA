package lr8.Example1;

import java.io.*;
import java.net.URL;

public class Ex2_ByteStreams {
    public static void main(String[] args) throws Exception {

        InputStream inFile = new FileInputStream("E:\\MyFile1.txt");
        read(inFile);

        InputStream inUrl = new URL("http://google.com").openStream();
        read(inUrl);

        byte[] arr = {65, 66, 67};
        read(new ByteArrayInputStream(arr));
    }

    static void read(InputStream in) throws IOException {
        int b;
        while ((b = in.read()) != -1)
            System.out.print((char) b);
        System.out.println();
        in.close();
    }
}
