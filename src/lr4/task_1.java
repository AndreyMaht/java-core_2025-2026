package lr4;

public class task_1 {

    public static void main(String[] args) {

        int figure = 15;
        int i;
        int j;
        int z;

        for (i=1; i<= figure; i++) {
            System.out.println("number string: " + i + " ");
            z = 0;
            for (j = -10; j < figure; j++) {
                System.out.println("+");
                z = z + 1;
            }
            System.out.println("Количество символов в строке" + z);
        }

    }





}
