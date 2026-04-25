package lr11.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_6 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(50));
            System.out.println(integers.get(i));
        }

        List<Integer> nums = divNumbers(integers, 5);
        System.out.println("\n" + "Список после: " + "\n");
        System.out.println(nums);

    }

    public static List<Integer> divNumbers(List<Integer> list, int num) {
        List<Integer> result = new ArrayList<>();

        for (Integer e : list) {
            if (e % num == 0) {
                result.add(e);
            }
        }

        return result;
    }

}
