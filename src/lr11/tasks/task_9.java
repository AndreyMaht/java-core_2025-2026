package lr11.tasks;

import java.util.ArrayList;
import java.util.List;

public class task_9 {
    public static void main(String[] args) {
        List<String> words = List.of("кот", "собака", "корова", "t324" , "кролик", "медведь", "олень", "пантера",
                "зебра", "пума","345");

        List<String> letters = filterOnlyLetters(words);

        System.out.println(letters);

    }

    public static List<String> filterOnlyLetters (List<String> list) {
        List<String> result = new ArrayList<>();

        for (String s : list) {
            if (s.isEmpty()) {
                continue;
            }
            boolean onlyLetters = true;
            for (char ch : s.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    onlyLetters = false;
                    break;
                }
            }
            if (onlyLetters) {
                result.add(s);
            }
        }
        return result;

    }

}
