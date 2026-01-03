package Timus.task_1000;

import java.util.Scanner;

public class task_1225 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 1 || n == 2) {
            System.out.println(2);
            return;
        }

        long a = 2;
        long b = 2;
        for (int i = 3; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
}
