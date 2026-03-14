package Timus.task_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task_1079 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> tests = new ArrayList<>();
        int maxN = 0;

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            tests.add(n);
            if (n > maxN) maxN = n;
        }

        if (maxN == 0) return; // нет тестов

        long[] a = new long[maxN + 1];
        a[0] = 0;
        a[1] = 1;

        for (int i = 1; i <= maxN / 2; i++) {
            a[2 * i] = a[i];
            if (2 * i + 1 <= maxN) {
                a[2 * i + 1] = a[i] + a[i + 1];
            }
        }

        long[] maxUpto = new long[maxN + 1];
        maxUpto[0] = a[0];
        for (int i = 1; i <= maxN; i++) {
            maxUpto[i] = Math.max(maxUpto[i - 1], a[i]);
        }

        for (int n : tests) {
            System.out.println(maxUpto[n]);
        }
    }
}
