package Timus.task_1000;

import java.util.Scanner;

public class task_1493 {

    public static boolean isLucky(int ticket) {
        int d6 = ticket % 10;
        int d5 = (ticket / 10) % 10;
        int d4 = (ticket / 100) % 10;

        int d3 = (ticket / 1000) % 10;
        int d2 = (ticket / 10000) % 10;
        int d1 = (ticket / 100000) % 10;

        return (d1 + d2 + d3) == (d4 + d5 + d6);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ticket = in.nextInt();

        if (isLucky(ticket - 1) || isLucky(ticket + 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        in.close();
    }
}
