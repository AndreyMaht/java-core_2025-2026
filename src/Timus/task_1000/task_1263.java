package Timus.task_1000;

import java.util.Scanner;

public class task_1263 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] votes = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int candidateId = in.nextInt();
            votes[candidateId]++;
        }

        for (int i = 1; i <= n; i++) {
            double percent = (votes[i] * 100.0) / m;
            System.out.printf("%.2f%%\n", percent);
        }

        in.close();

    }
}
