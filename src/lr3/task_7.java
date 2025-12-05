package lr3;

import java.util.Scanner;

public class task_7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int input = in.nextInt();

        char[] massive = new char[input];

        for (int i = 0; i < massive.length; i++) {

            massive[i] = (char) ('a' + i*2);
            System.out.println(massive[i]);

        }

        for (int i = massive.length - 1; i >= 0; i--) {
            System.out.println(massive[i]);
        }



    }
}
