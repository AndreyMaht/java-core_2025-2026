package lr1;

import java.time.LocalDate;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите ваш год рождения: ");
        int birthYear = in.nextInt();

        int currentYear = LocalDate.now().getYear();

        int result = currentYear - birthYear;

        System.out.println("Ваш возраст " + result);
    }
}
