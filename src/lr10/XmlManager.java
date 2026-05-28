package lr10;

import org.w3c.dom.*;
import java.io.File;
import java.util.List;
import java.util.stream.*;

public class XmlManager {

    static final String FILE = "src/lr10/example.xml";

    public static void main(String[] args) throws Exception {
        if (!new File(FILE).exists()) {
            XmlExample.createXml();
        }

        System.out.println("Добавление книги:");
        addBook("Преступление и наказание", "Фёдор Достоевский", "1866");

        System.out.println("\nПоиск по автору 'Лев Толстой':");
        searchByAuthor("Лев Толстой");

        System.out.println("\nПоиск по году '1967':");
        searchByYear("1967");

        System.out.println("\nУдаление книги 'Мастер и Маргарита':");
        deleteBook("Мастер и Маргарита");

        System.out.println("\nСписок книг после удаления:");
        listAll();
    }

    static void addBook(String title, String author, String year) throws Exception {
        Document doc = XmlExample.load(FILE);
        Element library = doc.getDocumentElement();
        XmlExample.addBook(doc, library, title, author, year);
        XmlExample.save(doc, FILE);
        System.out.println("Добавлена: " + title);
    }

    static void searchByAuthor(String author) throws Exception {
        Document doc = XmlExample.load(FILE);
        NodeList nodes = doc.getElementsByTagName("book");
        List<Element> found = IntStream.range(0, nodes.getLength())
                .mapToObj(i -> (Element) nodes.item(i))
                .filter(e -> e.getElementsByTagName("author")
                        .item(0).getTextContent().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        if (found.isEmpty()) {
            System.out.println("Книги не найдены");
        } else {
            found.forEach(e -> System.out.println(
                e.getElementsByTagName("title").item(0).getTextContent() + " (" +
                e.getElementsByTagName("year").item(0).getTextContent() + ")"
            ));
        }
    }

    static void searchByYear(String year) throws Exception {
        Document doc = XmlExample.load(FILE);
        NodeList nodes = doc.getElementsByTagName("book");
        IntStream.range(0, nodes.getLength())
                .mapToObj(i -> (Element) nodes.item(i))
                .filter(e -> e.getElementsByTagName("year")
                        .item(0).getTextContent().equals(year))
                .forEach(e -> System.out.println(
                    e.getElementsByTagName("title").item(0).getTextContent() + " | " +
                    e.getElementsByTagName("author").item(0).getTextContent()
                ));
    }

    static void deleteBook(String title) throws Exception {
        Document doc = XmlExample.load(FILE);
        NodeList nodes = doc.getElementsByTagName("book");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element book = (Element) nodes.item(i);
            if (book.getElementsByTagName("title").item(0)
                    .getTextContent().equals(title)) {
                book.getParentNode().removeChild(book);
                XmlExample.save(doc, FILE);
                System.out.println("Удалена: " + title);
                return;
            }
        }
        System.out.println("Книга не найдена: " + title);
    }

    static void listAll() throws Exception {
        Document doc = XmlExample.load(FILE);
        NodeList nodes = doc.getElementsByTagName("book");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element book = (Element) nodes.item(i);
            System.out.println(
                book.getElementsByTagName("title").item(0).getTextContent() + " | " +
                book.getElementsByTagName("author").item(0).getTextContent() + " | " +
                book.getElementsByTagName("year").item(0).getTextContent()
            );
        }
    }
}
