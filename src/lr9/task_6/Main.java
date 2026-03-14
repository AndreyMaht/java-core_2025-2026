package lr9.task_6;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "кот");
        map.put(2, "тигр");
        map.put(3, "слон");
        map.put(4, "жираф");
        map.put(5, "зебра");
        map.put(6, "бегемот");
        map.put(7, "носорог");
        map.put(8, "крокодил");
        map.put(9, "шиншилла");
        map.put(0, "страус");

        System.out.println("Строки, у которых ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            StringJoiner joiner = new StringJoiner(", ");
            for (String value : map.values()) {
                joiner.add(value);
            }
            System.out.println("\nКлюч 0 найден. Все строки словаря:");
            System.out.println(joiner);
        } else {
            System.out.println("\nКлюч 0 отсутствует.");
        }

        long product = 1L;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        if (found) {
            System.out.println("\nПроизведение ключей (длина строки > 5): " + product);
        } else {
            System.out.println("\nНет строк длиннее 5 символов.");
        }

    }

}
