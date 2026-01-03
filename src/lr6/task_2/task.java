package lr6.task_2;

public class task {

    private static int num = 0;

    public static void displayNum() {
        System.out.println("Текущее значение: " + num);
        num++;
        System.out.println("Поле увеличилось на 1");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            displayNum();
        }
    }

}
