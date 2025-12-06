package lr3;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = in.nextInt();

        int count = 0;
        int sum = 0;

//        for (int i = 1; count < n; i++) {
//            if (i % 5 == 2 || i % 3 == 1) {
//                System.out.print(i + " ");
//                sum += i;
//                count++;
//            }
//        }

        int i = 1;

        while (count < n) {
            if (i % 5 == 2 || i % 3 == 1) {
                System.out.println(i + " подходит");
                sum += i;
                count++;
            }
            i++;
        }

        System.out.println("Сумма = " + sum);

    }
}
