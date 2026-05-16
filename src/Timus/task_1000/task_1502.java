package Timus.task_1000;

import java.util.Scanner;

public class task_1502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (in.hasNextLong()) {
            long n = in.nextLong();
            long totalDiamonds = n * (n + 1) * (n + 2) / 2;

            System.out.println(totalDiamonds);
        }
    }
}
