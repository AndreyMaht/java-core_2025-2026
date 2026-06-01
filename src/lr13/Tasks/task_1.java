package lr13.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();

            int[] array = new int[size];
            int sum = 0;
            int count = 0;

            System.out.println("Введите элементы массива (целые числа):");

            for (int i = 0; i < size; i++) {
                array[i] = in.nextInt();
                if (array[i] > 0) {
                    sum += array[i];
                    count++;
                }
            }

            double average = (double) sum / count;
            if (count == 0) {
                throw new ArithmeticException("Деление на ноль: отсутствуют положительные элементы.");
            }

            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка вместо числа или нарушен целочисленный тип данных (int)!");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Положительные элементы в массиве отсутствуют (деление на ноль невозможно)!");
        } finally {
            System.out.println("Good work!");
            in.close();
        }

    }
}
