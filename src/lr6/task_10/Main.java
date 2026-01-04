package lr6.task_10;

import java.util.Arrays;

public class Main {

    public static int[] getMaxAndMinValue(int ... v) {

        Arrays.sort(v);

        int[] arrInt = new int[2];
        arrInt[0] = v[0];
        arrInt[1] = v[v.length-1];

        return arrInt;
    }

    public static void main(String[] args) {

        int[] arrInt = getMaxAndMinValue(130,20,3550,420);
        System.out.println(Arrays.toString(arrInt));

    }

}
