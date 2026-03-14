package Timus.task_1000;

import java.util.Scanner;

public class task_1083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] parts = line.split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = parts[1].length();

        int last = (n % k == 0) ? k : n % k;

        long result = 1;
        for (int i = n; i >= last; i -= k) {
            result *= i;
        }
        System.out.println(result);
    }

}
