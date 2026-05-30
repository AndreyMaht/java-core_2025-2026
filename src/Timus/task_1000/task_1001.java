package Timus.task_1000;

import java.util.ArrayList;
import java.util.Scanner;

public class task_1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Long> numbers = new ArrayList<>();

        while (scanner.hasNextLong()) {
            numbers.add(scanner.nextLong());
        }

        for (int i = numbers.size() - 1; i >= 0; i--) {
            long num = numbers.get(i);
            double sqrtResult = Math.sqrt(num);
            System.out.printf("%.4f\n", sqrtResult);
        }

        scanner.close();
    }
}
