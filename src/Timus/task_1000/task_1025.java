package Timus.task_1000;

import java.util.Arrays;
import java.util.Scanner;

public class task_1025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        int[] groups = new int[k];
        for (int i = 0; i < k; i++) {
            groups[i] = in.nextInt();
        }

        Arrays.sort(groups);

        int groupsNeeded = k / 2 + 1;
        int minSupporters = 0;

        for (int i = 0; i < groupsNeeded; i++) {
            minSupporters += (groups[i] / 2) + 1;
        }

        System.out.println(minSupporters);
        in.close();

    }
}
