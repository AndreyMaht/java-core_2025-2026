package lr1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваше имя: ");
        String name = in.nextLine();

        System.out.println("Введите ваш год рождения: ");
        int birthYear = in.nextInt();

        int currentYear = LocalDate.now().getYear();

        int result = currentYear - birthYear;

        System.out.println("Имя: " + name + " Возраст: " + result);

    }
}
