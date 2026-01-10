package lr8.task_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("source.txt"),
                            StandardCharsets.UTF_8));

            bw.write("Первая строка");
            bw.newLine();
            bw.write("Вторая строка");
            bw.newLine();
            bw.write("3.5 -2.1 7.8 -4.6 1.2");
            bw.newLine();
            bw.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("source.txt"),
                            StandardCharsets.UTF_8));

            BufferedWriter result = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("result.txt"),
                            StandardCharsets.UTF_8));

            br.readLine();
            String second = br.readLine();
            result.write(second);
            result.newLine();


            String[] nums = br.readLine().split("\\s+");
            for (String s : nums) {
                double d = Double.parseDouble(s);
                if (d > 0) {
                    result.write(String.valueOf(d));
                    result.newLine();
                }
            }

            br.close();
            result.close();
            System.out.println("Success");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }

    }

}
