package lr2;

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите любое число: ");
        int number = in.nextInt();

        if (number >= 5 && number <= 10) {
            System.out.println("Ваше число попало в диапазон от 5 до 10");
        } else {
            System.out.println("Ваше число не попало в диапазон от 5 до 10");
        }

    }
}
