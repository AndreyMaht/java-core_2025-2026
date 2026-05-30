package Timus;

import java.util.Scanner;

public class task_1991 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        long unusedBooms = 0;
        long survivingDroids = 0;

        for (int i = 0; i < n; i++) {
            int ai = in.nextInt();

            if (ai > k) {
                unusedBooms += (ai - k);
            } else {
                survivingDroids += (k - ai);
            }
        }

        System.out.println(unusedBooms + " " + survivingDroids);

        in.close();
    }
}
