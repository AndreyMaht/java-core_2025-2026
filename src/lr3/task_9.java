package lr3;

import java.util.Random;

public class task_9 {
    public static void main(String[] args) {

        Random random = new Random();

        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200);
            System.out.println("Элемент массива [" + i + "] = " + nums[i]);
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.println("\nМинимальное значение = " + min);

        System.out.print("Индексы с минимальным значением: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
