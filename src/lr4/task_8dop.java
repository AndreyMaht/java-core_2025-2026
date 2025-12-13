package lr4;

import java.util.Scanner;

public class task_8dop {
    public static void main(String[] args) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz ";

        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String value = in.nextLine();

        System.out.println("Введите ключ для шифрования");
        int key = in.nextInt();

        String shifr = "";
        for (int i = 0; i < value.length(); i++) {
            char letter = value.charAt(i);
            int index = alphabet.indexOf(letter);

            if (index != -1) {
                int newIndex = (index + key) % alphabet.length();
                shifr += alphabet.charAt(newIndex);

            } else {
                shifr += letter;
            }
        }

        System.out.println("Зашифровано: " + shifr);

        String original = "";
        for (int i = 0; i < shifr.length(); i++) {
            char letter = shifr.charAt(i);

            int index = alphabet.indexOf(letter);

            if (index != -1) {
                int newIndex = (index - key) % alphabet.length();
                if (newIndex < 0) {
                    newIndex = alphabet.length() + newIndex;
                }
                original += alphabet.charAt(newIndex);
            } else {
                original += letter;
            }
        }

        System.out.println("Расшифровано: " + original);




    }
}
