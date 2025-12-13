package lr4;

public class task_4 {
    public static void main(String[] args) {

        int height = 11;

        int[][] twoArray = new int[height][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i ; j++) {
                twoArray[i][j] = 2;
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
