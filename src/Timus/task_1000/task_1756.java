package Timus.task_1000;

import java.util.Scanner;

public class task_1756 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();

        int s = m*d1;
        int base = s/d2;
        int rem = s%d2;

        for (int i = 0; i < rem; i++) {
            System.out.print((base + 1) + " ");
        }
        for (int i = rem; i < d2; i++) {
            System.out.print(base + " ");
        }


    }
}
