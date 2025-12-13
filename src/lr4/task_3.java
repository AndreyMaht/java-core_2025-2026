package lr4;

public class task_3 {
    public static void main(String[] args) {

        int rows = 5;
        int cols = 8;

        int[][] twoArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                twoArray[i][j] = 2;
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
