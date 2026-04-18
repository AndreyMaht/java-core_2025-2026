package Course_project.parser;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.IIOException;
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
        String fileName = "rates.xlsx";

        String filePath = fileName;
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }

    public static Map<String, String> readExcelFile(String filePath) throws IOException {

        Map<String, String> rates = new HashMap<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return rates; // файл ещё не создан
        }

        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Курсы валют");

        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // пропускаем заголовок

            Cell codeCell = row.getCell(0);
            Cell valueCell = row.getCell(2);

            if (codeCell != null && valueCell != null) {
                rates.put(codeCell.getStringCellValue(), valueCell.getStringCellValue());
            }

        }

        workbook.close();
        inputStream.close();

        return rates;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите код валюты (USD, EUR и т.д.) или 'all' для всех: ");
        String userChoice = in.nextLine();
        userChoice = userChoice.toUpperCase();

        try {
            // Подключаемся к сайту
            Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/")
                    .userAgent("Mozilla/5.0")
                    .get();

            // Находим таблицу с курсами
            Elements rows = doc.select("table.data tr");

            Map<String, String> newRates = new HashMap<>();

            // Проходим по строкам
            for (Element row : rows) {
                Elements cols = row.select("td");

                if (cols.size() > 4) {
                    String charCode = cols.get(1).text();
                    String name = cols.get(3).text();
                    String value = cols.get(4).text();

                    newRates.put(charCode, value);

                    if (userChoice.equals("ALL") || userChoice.equals(charCode)) {
                        System.out.println(charCode + " | " + name + " | " + value);
                    }
                }
            }

            String fileName = "rates.xlsx";
            Map<String, String> oldRates = readExcelFile(fileName);

            boolean hasChanges = false;

            for (String code : newRates.keySet()) {
                if (!userChoice.equals("ALL") && !code.equals(userChoice)) {
                    continue;
                }
                String oldValue = oldRates.get(code);
                String newValue = newRates.get(code);

                if (oldValue == null) {
                    System.out.println("Новая валюта: " + code);
                    hasChanges = true;
                } else if (!oldValue.equals(newValue)) {
                    double oldVal = Double.parseDouble(oldValue.replace(",", "."));
                    double newVal = Double.parseDouble(newValue.replace(",", "."));

                    double diff = ((newVal - oldVal) / oldVal) * 100;

                    System.out.printf("Изменение: %s было: %s стало: %s (%.2f%%)%n",
                            code, oldValue, newValue, diff);
                    hasChanges = true;
                }

            }

            if (oldRates.isEmpty()) {
                System.out.println("Первый запуск — создаём файл");
                exportToExcel(rows);
            } else if (hasChanges) {
                System.out.println("Курсы изменились — обновляем файл");
                exportToExcel(rows);
            } else {
                System.out.println("Изменений нет");
            }
            //readExcelFile();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        in.close();
    }
}