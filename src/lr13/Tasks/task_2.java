package lr13.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] matrix = {
            {10,20,30},
            {40,50,60},
            {70,80,90}
        };

        try {
            System.out.print("Введите номер столбца для вывода (от 0 до " + (matrix[0].length - 1) + "): ");
            int colIndex = in.nextInt();

            System.out.println("Элементы столбца " + colIndex + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Вместо номера столбца введена строка или нецелое число!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Столбец с таким номером отсутствует в матрице!");
        } finally {
            System.out.println("Good work!");
            in.close();
        }

    }
}
