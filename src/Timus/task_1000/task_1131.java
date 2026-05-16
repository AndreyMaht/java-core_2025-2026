package Timus.task_1000;

import java.util.Scanner;

public class task_1131 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long K = in.nextLong();

        long hours = 0;
        long ready = 1;

        while (ready < K && ready < N) {
            ready = ready * 2;
            hours++;
        }
        long remaining;
        if (ready < N) {
            remaining = N - ready;
            hours += (remaining + K - 1) / K;
        }

        System.out.println(hours);
    }
}
