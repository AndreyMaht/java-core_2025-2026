package lr5.task_2;

public class task {

    char a;
    char b;

    public void printRange() {
        if (a <= b) {
            for (int i = a; i <= b; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = a; i >= b; i--) {
                System.out.print((char) i + " ");
            }
        }
        System.out.println();
    }

}
