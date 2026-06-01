package lr13.Tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов: ");
            int size = in.nextInt();

            byte[] array = new byte[size];
            byte sum = 0;

            System.out.println("Введите элементы типа byte :");

            for (int i = 0; i < size; i++) {
                array[i] = in.nextByte();

                int tempSum = sum + array[i];

                if (tempSum < Byte.MIN_VALUE || tempSum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Переполнение диапазона типа byte при вычислении!");
                }
                sum = (byte) tempSum;
            }

            System.out.println("Сумма элементов: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка или число которое выходит за допустимые границы типа byte");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Результат вычисления суммы вышел за границы диапазона byte!");
        } finally {
            System.out.println("Good Work");
            in.close();
        }

    }
}
