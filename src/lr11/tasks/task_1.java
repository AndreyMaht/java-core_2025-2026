package lr11.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "массив целых чисел: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(50));
            System.out.println(integers.get(i));
        }

        List<Integer> evens = evenNumbersList(integers);
        System.out.println("Чётные числа: " + evens);

    }

    public static List<Integer> evenNumbersList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        return result;
    }
}
