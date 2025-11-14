package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число: ");
        int num = in.nextInt();

        int firstNum = num - 1;
        int secondNum = num;
        int thirdNum = num + 1;

        int sum = firstNum + secondNum + thirdNum;

        int fourthNum = sum * sum;

        System.out.println("Последовательность:");
        System.out.println(firstNum);
        System.out.println(secondNum);
        System.out.println(thirdNum);
        System.out.println(fourthNum);
    }
}
