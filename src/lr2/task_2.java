package lr2;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число для проверки: ");
        double number = in.nextInt();

        boolean resultFive = (number % 5 == 2);
        boolean resultSeven = (number % 7 == 1);

        if (resultFive && resultSeven) {
            System.out.println("Число " + number + " удовлетворяет условиям:");
            System.out.println("При делении на 5 остаток = " + (number % 5));
            System.out.println("При делении на 7 остаток = " + (number % 7));
        } else {
            System.out.println("Число " + number + " НЕ удовлетворяет условиям:");
        }
    }
}
