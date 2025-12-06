package lr3;

import java.util.Arrays;
import java.util.Random;

public class task_10 {
    public static void main(String[] args) {

        Random random = new Random();

        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200);
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
        }

    }
}
