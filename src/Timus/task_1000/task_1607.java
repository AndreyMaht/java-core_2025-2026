package Timus.task_1000;

import java.util.Scanner;

public class task_1607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        int p = a;
        int t = c;

        if (t <= p) {
            System.out.println(p);
        } else {
            while (p < t) {
                p += b;
                if (p >= t) {
                    System.out.println(t);
                    return;
                }
                t -= d;
                if (t <= p) {
                    System.out.println(p);
                    return;
                }
            }
        }

    }
}
