package lr9.task_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = in.nextInt();

        int[] array = new int[size];

        System.out.println("Введите " + size + " целых чисел:");
        inputArray(array, 0, in);

        System.out.print("Массив: ");
        outputArray(array, 0);
        System.out.println();

        in.close();


    }

    public static void inputArray(int[] array, int index, Scanner scanner) {
        if (index >= array.length) {
            return;
        }

        System.out.println("Элемент [" + index + "]: ");
        array[index] = scanner.nextInt();

        inputArray(array, index + 1, scanner);
    }

    public static void outputArray(int[] array, int index) {
        if (index >= array.length) {
            return;
        }

        System.out.println(array[index]);

        if (index < array.length - 1) {
            System.out.print(", ");
        }

        outputArray(array, index + 1);
    }

}
