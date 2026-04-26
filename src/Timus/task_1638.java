package Timus;

import java.util.Scanner;

public class task_1638 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int P = in.nextInt();
        int C = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int d = Math.abs(A - B);
        int path;

        if (A == B) {
            path = P;
        } else if (A < B) {
            path = d * (P + 2 * C) - P;
        } else { // A > B
            path = d * (P + 2 * C) + P;
        }
        System.out.println(path);


    }
}
