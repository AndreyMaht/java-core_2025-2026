package Timus.task_1000;

import java.util.Scanner;

public class task_1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }
        int total = 0;
        for (int w : weights) total += w;
        int best = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) sum += weights[i];
            }
            if (sum <= total / 2 && sum > best) best = sum;
        }
        System.out.println(total - 2 * best);
    }
}