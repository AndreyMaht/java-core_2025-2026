package Course_project.parser;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelService {

    public static void exportToExcel(List<Currency> currencies) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Курсы валют");

        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("Код");
        headerRow.createCell(1).setCellValue("Валюта");
        headerRow.createCell(2).setCellValue("Курс");

        int rowNum = 1;

        for (Currency currency : currencies) {

            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(currency.getCode());
            row.createCell(1).setCellValue(currency.getName());
            row.createCell(2).setCellValue(currency.getValue());

            rowNum++;
        }

        FileOutputStream fos = new FileOutputStream("rates.xlsx");

        workbook.write(fos);

        workbook.close();
        fos.close();
    }

    public static Map<String, String> readExcelFile(String filePath) throws IOException {

        Map<String, String> rates = new HashMap<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return rates;
        }

        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Курсы валют");

        for (Row row : sheet) {

            if (row.getRowNum() == 0) continue;

            Cell codeCell = row.getCell(0);
            Cell valueCell = row.getCell(2);

            rates.put(
                    codeCell.getStringCellValue(),
                    valueCell.getStringCellValue()
            );
        }

        workbook.close();
        fis.close();

        return rates;
    }
}