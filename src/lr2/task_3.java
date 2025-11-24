package lr2;

import java.util.Scanner;

public class task_3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите любое целое число: ");
        int number = in.nextInt();

        double proverka = number % 4;

        if (number > 10 && proverka == 0) {
            System.out.println("Число удовлетворяет критериям. Делится на 4 и больше 10");
        } else {
            System.out.println("Число не удовлетворяет критериям.");
        }

    }

}
