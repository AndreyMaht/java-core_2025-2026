package lr11.tasks;

import java.util.ArrayList;
import java.util.List;

public class task_5 {
    public static void main(String[] args) {
        List<String> words = List.of("кот", "собака", "корова", "кролик");
        List<String> filtered = filterBySubstring(words, "ко");
        System.out.println(filtered);
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();

        for (String str : strings) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }
        return result;
    }
}
