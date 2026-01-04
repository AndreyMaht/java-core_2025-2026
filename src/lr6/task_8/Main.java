package lr6.task_8;

public class Main {

    public static void charsMassive(int[] arrayInt) {

        int sum = 0;

        for (int i = 0; i < arrayInt.length; i++) {

            sum += arrayInt[i];

        }

        int len = arrayInt.length;

        int avg = sum/len;

        System.out.println(avg);

    }

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 5;
        arr[1] = 63;
        arr[2] = 23;
        arr[3] = 12;
        arr[4] = 85;

        Main.charsMassive(arr);

    }

}
