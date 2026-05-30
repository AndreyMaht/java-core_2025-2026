package Timus.task_1000;

import java.util.Scanner;

public class task_1617 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (!in.hasNextInt()) return;
        int n = in.nextInt();

        int[] counts = new int[701];

        for (int i = 0; i < n; i++) {
            int diameter = in.nextInt();
            counts[diameter]++;
        }

        int totalTrams = 0;

        for (int d = 600; d <= 700; d++) {
            totalTrams += counts[d] / 4;
        }

        System.out.println(totalTrams);
        in.close();

    }
}
