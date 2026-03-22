package Course_project.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CurrencyParser {

    public static void main(String[] args) {
        try {
            // Подключаемся к сайту
            Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/")
                    .userAgent("Mozilla/5.0")
                    .get();

            // Находим таблицу с курсами
            Elements rows = doc.select("table.data tr");

            // Проходим по строкам
            for (Element row : rows) {
                Elements cols = row.select("td");

                if (cols.size() > 4) {
                    String charCode = cols.get(1).text(); // Код валюты (USD)
                    String name = cols.get(3).text();     // Название
                    String value = cols.get(4).text();    // Курс

                    System.out.println(charCode + " | " + name + " | " + value);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}