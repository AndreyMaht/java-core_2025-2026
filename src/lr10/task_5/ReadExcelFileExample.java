package lr10.task_5;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFileExample {
    public static void main(String[] args) {
        String filePath = "src/lr10/task_1/example3.xlsx";
        String sheetName = "Товары";

        try (FileInputStream inputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Ошибка: Лист с именем '" + sheetName + "' не найден.");
                System.out.println("Доступные листы:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.out.println("  - " + workbook.getSheetName(i));
                }
                return;
            }

            System.out.println("Содержимое листа '" + sheetName + "':\n");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден по пути " + filePath);
            System.out.println("Проверьте, что файл существует и путь указан верно.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            System.out.println("Возможно, файл повреждён или используется другой программой.");
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}
