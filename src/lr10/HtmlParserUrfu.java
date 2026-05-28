package lr10;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HtmlParserUrfu {

    static final String URL = "http://fat.urfu.ru/index.html";
    static final String OUT = "src/lr10/news.txt";
    static final int MAX_RETRIES = 3;
    static final int TIMEOUT = 10000;

    public static void main(String[] args) {
        new File("src/lr10").mkdirs();
        Document doc = connectWithRetry();
        if (doc == null) {
            System.out.println("Не удалось подключиться к сайту после " + MAX_RETRIES + " попыток");
            return;
        }
        parseAndSave(doc);
    }

    static Document connectWithRetry() {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + "/" + MAX_RETRIES);
                Document doc = Jsoup.connect(URL).timeout(TIMEOUT).get();
                System.out.println("Подключение успешно");
                return doc;
            } catch (IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
                if (attempt < MAX_RETRIES) {
                    System.out.println("Повтор через 2 секунды...");
                    try { Thread.sleep(2000); } catch (InterruptedException ex) { break; }
                }
            }
        }
        return null;
    }

    static void parseAndSave(Document doc) {
        Elements news = doc.select(".news-item, .news_item, li.news");

        try (PrintWriter pw = new PrintWriter(new FileWriter(OUT))) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
            pw.println("Новости с " + URL);
            pw.println("Дата получения: " + timestamp);
            pw.println("---");

            if (news.isEmpty()) {
                System.out.println("Элементы новостей не найдены, вывод заголовков страницы:");
                Elements headings = doc.select("h1, h2, h3");
                for (Element h : headings) {
                    String text = h.text().trim();
                    if (!text.isEmpty()) {
                        System.out.println(text);
                        pw.println(text);
                    }
                }
            } else {
                for (Element item : news) {
                    String topic = item.getElementsByClass("news-topic").text();
                    String date  = item.getElementsByClass("news-date").text();
                    if (topic.isEmpty()) topic = item.text();
                    System.out.println("Тема: " + topic);
                    System.out.println("Дата: " + date);
                    pw.println("Тема: " + topic);
                    pw.println("Дата: " + date);
                    pw.println();
                }
            }

            System.out.println("\nДанные сохранены в файл: " + OUT);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
