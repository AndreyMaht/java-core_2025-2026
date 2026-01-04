package lr6.task_7;

import java.util.Arrays;

public class Main {

    public static int[] charsMassive(char[] arrayChar) {

        int[] arrayInt = new int[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++) {
            arrayInt[i] = arrayChar[i];
        }

        return arrayInt;
    }

    public static void main(String[] args) {

        char[] codeChars = new char[5];
        codeChars[0] = 'A';
        codeChars[1] = 'B';
        codeChars[2] = 'C';
        codeChars[3] = 'D';
        codeChars[4] = 'F';

        int[] result = Main.charsMassive(codeChars);

        System.out.println(Arrays.toString(result));

    }

}
