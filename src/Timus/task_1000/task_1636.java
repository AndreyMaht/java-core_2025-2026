package Timus.task_1000;

import java.util.Scanner;

public class task_1636 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int totalAttempts = 0;
        for (int i = 0; i < 10; i++) {
            totalAttempts += in.nextInt();
        }

        int idealTime = t2 - (totalAttempts * 20);

        if (idealTime < t1) {
            System.out.println("Dirty debug :(");
        } else {
            System.out.println("No chance.");
        }

        in.close();

    }
}
