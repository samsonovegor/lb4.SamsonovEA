package lr10;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlExample {

    static final String FILE = "src/lr10/example.xml";

    public static void main(String[] args) throws Exception {
        new File("src/lr10").mkdirs();
        createXml();
        System.out.println();
        readXml();
    }

    static void createXml() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element library = doc.createElement("library");
        doc.appendChild(library);

        addBook(doc, library, "Война и мир", "Лев Толстой", "1869");
        addBook(doc, library, "Мастер и Маргарита", "Михаил Булгаков", "1967");

        save(doc, FILE);
        System.out.println("XML файл создан: " + FILE);
    }

    static void readXml() throws Exception {
        Document doc = load(FILE);
        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

        NodeList books = doc.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            System.out.println(
                book.getElementsByTagName("title").item(0).getTextContent() + " | " +
                book.getElementsByTagName("author").item(0).getTextContent() + " | " +
                book.getElementsByTagName("year").item(0).getTextContent()
            );
        }
    }

    static void addBook(Document doc, Element parent, String title, String author, String year) {
        Element book = doc.createElement("book");
        addElement(doc, book, "title", title);
        addElement(doc, book, "author", author);
        addElement(doc, book, "year", year);
        parent.appendChild(book);
    }

    static void addElement(Document doc, Element parent, String tag, String text) {
        Element el = doc.createElement(tag);
        el.setTextContent(text);
        parent.appendChild(el);
    }

    static Document load(String path) throws Exception {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(path));
    }

    static void save(Document doc, String path) throws Exception {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.transform(new DOMSource(doc), new StreamResult(new File(path)));
    }
}
