package lr11.tasks;

import java.util.*;

public class task_2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<Integer> integers1 = new ArrayList<>();

        Random random = new Random();

        System.out.println("\n" + "Первый массив целых чисел: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(20));
            System.out.println(integers.get(i));
        }

        System.out.println("\n" + "Второй массив целых чисел: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers1.add(random.nextInt(20));
            System.out.println(integers1.get(i));
        }

        List<Integer> array = arrayComparison(integers, integers1);
        System.out.println("Общие числа из двух массивов: " + array);

    }

    public static List<Integer> arrayComparison(List<Integer> list, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(list);

        for (Integer num : list2) {
            if (set.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }

        return result;

    }

}
