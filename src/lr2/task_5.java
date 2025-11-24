package lr2;

import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int number = in.nextInt();

        int thousands = (number / 1000) % 10;

        if (number < 1000) {
            System.out.print("В этом числе нет тысяч!");
        } else if (number >= 1000) {
            System.out.print("В вашем числе: " + thousands + "тысяч");
        }

    }
}
