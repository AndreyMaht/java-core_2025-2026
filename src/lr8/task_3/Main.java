package lr8.task_3;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String consonants = "бвгджзйклмнпрстфхцчшщ";

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("text.txt"), "UTF-8"));
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("result1.txt"), "UTF-8"))
        ) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] words = line.split("[^а-яА-ЯёЁ]+");

                int count = 0;
                StringBuilder sb = new StringBuilder();

                for (String word : words) {
                    if (!word.isEmpty()) {
                        char first = Character.toLowerCase(word.charAt(0));
                        if (consonants.indexOf(first) != -1) {
                            sb.append(word).append(" ");
                            count++;
                        }
                    }
                }

                if (count > 0) {
                    bw.write("Строка " + lineNumber + ": ");
                    bw.write(sb.toString());
                    bw.write(" (количество слов: " + count + ")");
                    bw.newLine();
                }
            }

            System.out.println("Success");

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }

}
