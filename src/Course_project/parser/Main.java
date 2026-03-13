package Course_project.parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://edu.itlearn.ru/mod/quiz/startattempt.php").get();
            Elements titleElements = document.select("p");

            if (titleElements.isEmpty()) {
                System.out.println("На странице нет.");
            } else {
                titleElements.stream()
                        .map(Element::text)
                        .forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.printf("Ошибка при загрузке страницы: %s%n", e.getMessage());
        }
    }
}
