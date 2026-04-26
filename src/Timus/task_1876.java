package Timus;

import java.util.Scanner;

public class task_1876 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int result = Math.max(2*a + 39, 2*b + 40);
        System.out.println(result);

    }
}
