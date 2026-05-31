package timus;

import java.util.*;
        import java.io.*;

public class timus1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> rooms = new HashSet<>();
        String gateway = br.readLine().trim();
        rooms.add(gateway);
        String line;
        while (!(line = br.readLine().trim()).equals("#")) {
            String[] parts = line.split("-");
            rooms.add(parts[0]);
            rooms.add(parts[1]);
        }
        System.out.println(rooms.size() - 1);
    }
}
