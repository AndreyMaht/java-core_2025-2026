package Timus.task_2000;

import java.util.Scanner;

public class task_2056 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfExams = in.nextInt();

        int[] array = new int[numberOfExams];

        for (int i = 0; i < numberOfExams; i++) {
            array[i] = in.nextInt();
        }

        int sum = 0;
        boolean hasThree = false;
        boolean allFives = true;

        for (int i = 0; i < array.length; i++) {
            int currentGrade = array[i];
            sum += currentGrade;

            if (currentGrade == 3) {
                hasThree = true;
            }

            if (currentGrade != 5) {
                allFives = false;
            }
        }

        double averageScore = (double) sum / numberOfExams;

        String scholarship;

        if (hasThree) {
            scholarship = "None";
        } else if (allFives) {
            scholarship = "Named";
        } else if (averageScore >= 4.5) {
            scholarship = "High";
        } else {
            scholarship = "Common";
        }

        System.out.println(scholarship);
        in.close();


    }

}
