package lr3;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел в последовательности: ");
        int size = in.nextInt();

        int a = 0;
        int b = 1;

        for (int i = 0; i < size; i++) {
            int next = a + b;
            a = b;
            b = next;

            System.out.println(next);

        }



    }
}
