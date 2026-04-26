package Timus.task_1000;

import java.util.Scanner;

public class task_1327 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int one = ((B+1)/2) - (A/2);

        System.out.println(one);

    }
}
