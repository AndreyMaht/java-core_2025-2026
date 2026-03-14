package lr9.task_2;

import java.util.Scanner;

public class main {

    public static void printBinary(int x) {
        System.out.println("x= " + x);
        if (x == 0) {
            return;
        }
        printBinary(x / 2);
        System.out.print(x % 2);

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число: ");
        int n = in.nextInt();

        printBinary(n);
    }
}
