package lr4;

import java.util.Random;

public class task_6 {
    public static void main(String[] args) {

        Random random = new Random();

        int rows = 5;
        int cols = 6;

        int[][] twoArray = new int[rows][cols];

        System.out.println("Исходный массив до удаления");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                twoArray[i][j] = 10 + random.nextInt(20);
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }

        int indexRows = random.nextInt(rows);
        int indexCols = random.nextInt(cols);

        System.out.println("Удаляем строку " + (indexRows + 1) + " и столбец " + (indexCols + 1));
        System.out.println("(индексы: строка " + indexRows + ", столбец " + indexCols + ")");

        int[][] newTwoArray = new int[rows - 1][cols - 1];

        for (int i = 0, newI = 0; i < rows; i++) {
            if (i == indexRows) {
                continue;
            }
            for (int j = 0, newJ = 0; j < cols; j++) {
                if (j == indexCols) {
                    continue;
                }

                newTwoArray[newI][newJ] = twoArray[i][j];
                newJ++;
            }
            newI++;
        }

        System.out.println("Новый массив после удаления");

        for (int i = 0; i < newTwoArray.length; i++) {
            for (int j = 0; j < newTwoArray[i].length; j++) {
                System.out.print(newTwoArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
