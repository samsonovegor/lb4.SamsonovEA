package lr10;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class JsonExample {

    static final String FILE = "src/lr10/example.json";

    public static void main(String[] args) throws Exception {
        new File("src/lr10").mkdirs();
        createJson();
        System.out.println();
        readJson();
    }

    @SuppressWarnings("unchecked")
    static void createJson() throws Exception {
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Java Programming");
        book1.put("author", "John Doe");
        book1.put("year", "2015");
        books.add(book1);

        JSONObject book2 = new JSONObject();
        book2.put("title", "Python Programming");
        book2.put("author", "Jane Smith");
        book2.put("year", "2018");
        books.add(book2);

        JSONObject book3 = new JSONObject();
        book3.put("title", "Ruby Programming");
        book3.put("author", "Bob Johnson");
        book3.put("year", "2016");
        books.add(book3);

        JSONObject root = new JSONObject();
        root.put("books", books);

        try (FileWriter fw = new FileWriter(FILE)) {
            fw.write(root.toJSONString());
        }
        System.out.println("JSON файл создан: " + FILE);
    }

    static void readJson() throws Exception {
        JSONObject root = (JSONObject) new JSONParser().parse(new FileReader(FILE));
        System.out.println("Ключ: " + root.keySet().iterator().next());

        JSONArray books = (JSONArray) root.get("books");
        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            System.out.println(
                book.get("title") + " | " +
                book.get("author") + " | " +
                book.get("year")
            );
        }
    }

    static JSONObject loadJson() throws Exception {
        return (JSONObject) new JSONParser().parse(new FileReader(FILE));
    }

    static void saveJson(JSONObject root) throws Exception {
        try (FileWriter fw = new FileWriter(FILE)) {
            fw.write(root.toJSONString());
        }
    }
}
