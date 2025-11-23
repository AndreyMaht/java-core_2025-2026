package lr2;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число для проверки: ");
        double number = in.nextInt();

        if (number % 3 == 0) {
            System.out.println("Ваше число " + number + " делится на 3");
            System.out.println("Результат деления: " + (number / 3));
        } else {
            System.out.println("Ваше число " + number + " НЕ делится на 3");
            System.out.println("Остаток от деления: " + (number % 3));
        }

    }

}
