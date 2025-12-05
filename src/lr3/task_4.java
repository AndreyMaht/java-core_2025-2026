package lr3;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите 2 целых числа");
        int a = in.nextInt();
        int b = in.nextInt();

//        if (a < b) {
//            for (int i = a; i < b; i++) {
//                System.out.println(i);
//            }
//        }

        while (a < b) {
            a++;
            System.out.println(a);
        }

    }
}
