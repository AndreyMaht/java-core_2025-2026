package lr10.task_4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class NewsParser {

    private static final String NEWS_URL = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "news.txt";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        Document doc = null;
        int attempt = 0;

        while (attempt < MAX_RETRIES) {
            try {
                System.out.println("Попытка подключения " + (attempt + 1) + " из " + MAX_RETRIES);
                doc = Jsoup.connect(NEWS_URL).get();
                System.out.println("Подключение успешно!\n");
                break;
            } catch (IOException e) {
                attempt++;
                System.err.println("Ошибка при получении HTML-кода: " + e.getMessage());
                if (attempt < MAX_RETRIES) {
                    System.err.println("Повторная попытка через " + RETRY_DELAY_MS / 1000 + " секунд...");
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Ожидание прервано");
                        break;
                    }
                } else {
                    System.err.println("Не удалось подключиться после " + MAX_RETRIES + " попыток. Программа завершена.");
                    return;
                }
            }
        }

        if (doc == null) {
            System.err.println("Не удалось загрузить документ.");
            return;
        }

        Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                "tr > td:nth-child(1)");

        if (newsParent.isEmpty()) {
            System.err.println("Не удалось найти блок новостей на странице. Возможно, структура сайта изменилась.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE, false))) {

            writer.println("Новости с сайта УрФУ");
            writer.println("=====================\n");

            for (int i = 3; i < 20; i++) {
                if (i % 2 != 0) {
                    List<Node> nodes = newsParent.get(0).childNodes();
                    if (i >= nodes.size()) break;

                    Element block = (Element) nodes.get(i);

                    Elements titleElem = block.getElementsByClass("blocktitle");
                    String title = (titleElem.isEmpty() || titleElem.get(0).childNodes().isEmpty())
                            ? "Нет темы"
                            : titleElem.get(0).childNodes().get(0).toString();

                    Elements dateElem = block.getElementsByClass("blockdate");
                    String date = (dateElem.isEmpty() || dateElem.get(0).childNodes().isEmpty())
                            ? "Нет даты"
                            : dateElem.get(0).childNodes().get(0).toString();

                    System.out.println("Тема: " + title);
                    System.out.println("Дата: " + date + "\n");

                    writer.println("Тема: " + title);
                    writer.println("Дата: " + date);
                    writer.println();
                }
            }
            System.out.println("Новости успешно сохранены в файл: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
