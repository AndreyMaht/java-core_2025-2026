package lr9.taskCollections;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        // Заполняем начальными данными (по 100 000 элементов)
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
            linkedHashMap.put(i, i);
        }

        // 1. Добавление в начало (для списков)
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList добавление в начало: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList добавление в начало: " + (end - start) + " мс");

        System.out.println("LinkedHashMap: нет операции добавления в начало");

        // 2. Добавление в конец
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList добавление в конец: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList добавление в конец: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 100000; i < 110000; i++) { // новые ключи
            linkedHashMap.put(i, i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedHashMap добавление (put): " + (end - start) + " мс");

        // 3. Добавление в середину (для списков)
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int middle = arrayList.size() / 2;
            arrayList.add(middle, i);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList добавление в середину: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int middle = linkedList.size() / 2;
            linkedList.add(middle, i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList добавление в середину: " + (end - start) + " мс");
        System.out.println("LinkedHashMap: нет операции добавления в середину");

        // 4. Удаление из начала (для списков)
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList удаление из начала: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList удаление из начала: " + (end - start) + " мс");
        System.out.println("LinkedHashMap: нет операции удаления из начала");

        // 5. Удаление из конца (для списков)
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList удаление из конца: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList удаление из конца: " + (end - start) + " мс");

        // Для LinkedHashMap удаление по ключу
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedHashMap.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedHashMap удаление по ключу: " + (end - start) + " мс");

        // 6. Удаление из середины (для списков)
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int middle = arrayList.size() / 2;
            arrayList.remove(middle);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList удаление из середины: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int middle = linkedList.size() / 2;
            linkedList.remove(middle);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList удаление из середины: " + (end - start) + " мс");
        System.out.println("LinkedHashMap: нет операции удаления из середины");

        // 7. Получение элемента по индексу (для списков) / по ключу (для Map)
        // Для списков
        Random rand = new Random();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = rand.nextInt(arrayList.size());
            arrayList.get(index);
        }
        end = System.currentTimeMillis();
        System.out.println("\nArrayList получение по индексу: " + (end - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = rand.nextInt(linkedList.size());
            linkedList.get(index);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList получение по индексу: " + (end - start) + " мс");

        // Для LinkedHashMap получение по ключу
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(linkedHashMap.size());
            linkedHashMap.get(key);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedHashMap получение по ключу: " + (end - start) + " мс");

    }
}
