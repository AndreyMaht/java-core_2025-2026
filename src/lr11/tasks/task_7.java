package lr11.tasks;

import java.util.ArrayList;
import java.util.List;

public class task_7 {
    public static void main(String[] args) {
        List<String> words = List.of("кот", "собака", "корова", "кролик", "медведь", "олень", "пантера",
                "зебра", "пума");

        List<String> filtered = FilteredStrings(words, 6);
        System.out.println(filtered);
    }

    public static List<String> FilteredStrings(List<String> list, int value) {
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (s.length() > value) {
                result.add(s);
            }
        }

        return result;

    }
}
