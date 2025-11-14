package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        double numOne = in.nextInt();

        System.out.println("Введите второе число: ");
        double numTwo = in.nextInt();

        double sum = numOne + numTwo;
        double difference = numOne - numTwo;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);
    }
}
