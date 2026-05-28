package lr10;

import org.json.simple.*;
import java.io.File;
import java.util.*;

public class JsonManager {

    public static void main(String[] args) throws Exception {
        if (!new File(JsonExample.FILE).exists()) {
            JsonExample.createJson();
        }

        System.out.println("Поиск по автору 'Jane Smith':");
        searchByAuthor("Jane Smith");

        System.out.println("\nДобавление книги:");
        addBook("Kotlin Programming", "Alex Ivanov", "2022");

        System.out.println("\nУдаление книги 'Ruby Programming':");
        deleteBook("Ruby Programming");

        System.out.println("\nСписок книг после изменений:");
        listAll();
    }

    static void searchByAuthor(String author) throws Exception {
        JSONObject root = JsonExample.loadJson();
        JSONArray books = (JSONArray) root.get("books");
        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            if (author.equals(book.get("author").toString())) {
                System.out.println(
                        "Название: " + book.get("title").toString() +
                                ", Год: " + book.get("year").toString()
                );
            }
        }
    }

    @SuppressWarnings("unchecked")
    static void addBook(String title, String author, String year) throws Exception {
        JSONObject root = JsonExample.loadJson();
        JSONArray books = (JSONArray) root.get("books");

        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("author", author);
        newBook.put("year", year);
        books.add(newBook);

        JsonExample.saveJson(root);
        System.out.println("Добавлена: " + title);
    }

    static void deleteBook(String title) throws Exception {
        JSONObject root = JsonExample.loadJson();
        JSONArray books = (JSONArray) root.get("books");

        Iterator<?> iterator = books.iterator();
        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (title.equals(book.get("title").toString())) {
                iterator.remove();
                JsonExample.saveJson(root);
                System.out.println("Удалена: " + title);
                return;
            }
        }
        System.out.println("Книга не найдена: " + title);
    }

    static void listAll() throws Exception {
        JSONObject root = JsonExample.loadJson();
        JSONArray books = (JSONArray) root.get("books");
        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            System.out.println(
                    book.get("title").toString() + " | " +
                            book.get("author").toString() + " | " +
                            book.get("year").toString()
            );
        }
    }
}