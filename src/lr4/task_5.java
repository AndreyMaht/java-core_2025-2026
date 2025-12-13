package lr4;

import java.util.Random;

public class task_5 {
    public static void main(String[] args) {

        Random random = new Random();

        int rows = 3 + random.nextInt(4);
        int cols = 3 + random.nextInt(4);

        int[][] twoArray = new int[rows][cols];

        System.out.println("Исходный массив " + rows + "x" + cols + ":");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                twoArray[i][j] = 10 + random.nextInt(10);
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }

        int[][] cloneTwoArray = new int[cols][rows];

        System.out.println("Другой массив " + rows + "x" + cols + ":");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cloneTwoArray[j][i] = twoArray[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(cloneTwoArray[i][j] + " ");
            }
            System.out.println();
        }


    }
}
