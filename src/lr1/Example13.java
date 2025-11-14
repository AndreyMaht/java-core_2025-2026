package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int numOne = in.nextInt();

        System.out.println("Введите второе число: ");
        int numTwo = in.nextInt();

        int result = numOne + numTwo;

        System.out.println("Ответ: " + result);
    }
}
