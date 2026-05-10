package Course_project.parser;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CurrencyParser {

    public static String parseAndCompare(String userChoice) {

        StringBuilder result = new StringBuilder();

        result.append("<html><body style='font-family:Segoe UI; font-size:16px;'>");

        System.out.println("Введите код валюты (USD, EUR и т.д.) или 'all' для всех: ");
        userChoice = userChoice.toUpperCase();

        try {
            Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/")
                    .userAgent("Mozilla/5.0")
                    .get();

            Elements rows = doc.select("table.data tr");

            List<Currency> currencies = new ArrayList<>();
            Map<String, String> newRates = new HashMap<>();

            for (Element row : rows) {
                Elements cols = row.select("td");

                if (cols.size() > 4) {
                    String charCode = cols.get(1).text();
                    String name = cols.get(3).text();
                    String value = cols.get(4).text();

                    Currency currency = new Currency(charCode, name, value);
                    currencies.add(currency);
                    newRates.put(charCode, value);

                    if (userChoice.equals("ALL") || userChoice.equals(charCode)) {
                        result.append(charCode).append(" | ").append(name).append(" | ").append(value).append(" руб").append("<br>");
                    }
                }
            }

            String fileName = "rates.xlsx";
            Map<String, String> oldRates = ExcelService.readExcelFile(fileName);

            boolean hasChanges = false;

            for (String code : newRates.keySet()) {
                if (!userChoice.equals("ALL") && !code.equals(userChoice)) {
                    continue;
                }
                String oldValue = oldRates.get(code);
                String newValue = newRates.get(code);

                if (oldValue == null) {
                    result.append("Новая валюта: ").append(code).append("<br>");
                    hasChanges = true;
                } else if (!oldValue.equals(newValue)) {
                    double oldVal = Double.parseDouble(oldValue.replace(",", "."));
                    double newVal = Double.parseDouble(newValue.replace(",", "."));

                    double diff = ((newVal - oldVal) / oldVal) * 100;

                    String arrow;
                    String color;

                    if (diff > 0) {
                        arrow = "📈";
                        color = "green";
                    } else {
                        arrow = "📉";
                        color = "red";
                    }

                    result.append(String.format(
                            "%s <b>%s</b>: было %s → стало %s " +
                                    "<span style='color:%s;'>(%.2f%%)</span><br>",
                            arrow,
                            code,
                            oldValue,
                            newValue,
                            color,
                            diff
                    ));

                    hasChanges = true;
                }
            }

            if (oldRates.isEmpty()) {
                result.append("Первый запуск — создаём файл");
                ExcelService.exportToExcel(currencies);
            } else if (hasChanges) {
                result.append("Курсы изменились — обновляем файл");
                ExcelService.exportToExcel(currencies);
            } else {
                result.append("Изменений нет");
            }

        } catch (IOException e) {
            result.append("Ошибка: ").append(e.getMessage()).append("\n");
        }

        result.append("</body></html>");

        return result.toString();

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите код валюты (USD, EUR и т.д.) или 'all' для всех: ");
        String userChoice = scanner.nextLine().trim().toUpperCase();
        scanner.close();

        String result = parseAndCompare(userChoice);
        System.out.println(result);

    }
}