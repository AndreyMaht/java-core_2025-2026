package lr11.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class task_10 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            ints.add(random.nextInt(50));
            System.out.println(ints.get(i));
        }

        List<Integer> numbers = minNums(ints, 10);

        System.out.println("\n" + "Список после: " + "\n");
        System.out.println(numbers);

    }

    public static List<Integer> minNums (List<Integer> list, int value) {

        return list.stream()
                .filter(e -> e < value)
                .collect(Collectors.toList());
    }
}
