package Timus.task_1000;

import java.util.Scanner;

public class task_1243 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        int remainder = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            remainder = (remainder * 10 + digit) % 7;

        }
        System.out.println(remainder);
    }
}
