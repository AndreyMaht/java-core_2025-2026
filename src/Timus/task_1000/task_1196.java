package Timus.task_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class task_1196 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        HashSet<Integer> teacherDates = new HashSet<>();
        for (int i = 0; i < n; i++) {
            teacherDates.add(Integer.parseInt(reader.readLine().trim()));
        }

        int m = Integer.parseInt(reader.readLine().trim());
        int matchCount = 0;

        for (int i = 0; i < m; i++) {
            int studentDate = Integer.parseInt(reader.readLine().trim());

            if (teacherDates.contains(studentDate)) {
                matchCount++;
            }
        }

        System.out.println(matchCount);

    }
}
