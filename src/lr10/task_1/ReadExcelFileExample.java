package lr10.task_1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFileExample {
    public static void main(String[] args) throws IOException {
        String filePath = "src/lr10/task_1/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Товары");

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.println(cell.toString() + "\t");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();

    }
}
