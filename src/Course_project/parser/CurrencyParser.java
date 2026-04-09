package Course_project.parser;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CurrencyParser {

    public static void exportToExcel (Elements rows) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Курсы валют");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Код валюты");
        headerRow.createCell(1).setCellValue("Валюта");
        headerRow.createCell(2).setCellValue("Курс");

        int rowNum = 1;

        for (Element row : rows) {
            Elements cols = row.select("td");

            if (cols.size() > 4) {
                Row dataRow = sheet.createRow(rowNum);

                String charCode = cols.get(1).text();
                String name = cols.get(3).text();
                String value = cols.get(4).text();

                dataRow.createCell(0).setCellValue(charCode);
                dataRow.createCell(1).setCellValue(name);
                dataRow.createCell(2).setCellValue(value);

                rowNum += 1;
            }
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        LocalDate today = LocalDate.now();
        String dateStr = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String fileName = "rates_" + dateStr + ".xlsx";

        String filePath = fileName;
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }

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
                    String charCode = cols.get(1).text();
                    String name = cols.get(3).text();
                    String value = cols.get(4).text();
                    System.out.println(charCode + " | " + name + " | " + value);
                }
            }

            exportToExcel(rows);

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}