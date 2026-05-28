package lr10;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class HtmlParser {

    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://itlearn.ru/first-steps")
                .timeout(10000)
                .get();

        Elements links = doc.select("a[href]");
        System.out.println("Ссылки на странице itlearn.ru:");
        for (Element link : links) {
            String url = link.attr("abs:href");
            if (!url.isEmpty()) {
                System.out.println(url);
            }
        }
    }
}
