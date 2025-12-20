package lr5.task_3;

public class Task {

    private int a;
    private int b;

    public void twoInts() {
        this.a = 0;
        this.b = 0;
        System.out.println("Вызван конструктор без аргументов.");
    }

    public void oneArg(int a) {
        this.a = a;
        System.out.println(a);
    }

    public void twoArg(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println(a + " " + b);
    }

}
