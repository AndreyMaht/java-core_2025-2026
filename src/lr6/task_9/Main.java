package lr6.task_9;

import java.util.Arrays;

public class Main {

    public static char[] massInt(char[] arrCh) {

        char[] result = arrCh.clone();

        for (int i = 0; i < result.length / 2; i++) {
            char temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        return result;
    }

    public static void main(String[] args) {

        char[] arr = new char[4];
        arr[0] = 'A';
        arr[1] = 'B';
        arr[2] = 'C';
        arr[3] = 'D';

        System.out.println("Исходный массив: " + Arrays.toString(arr));

        char[] result = Main.massInt(arr);

        System.out.println("После обмена: " + Arrays.toString(result));

    }

}
