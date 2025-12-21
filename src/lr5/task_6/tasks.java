package lr5.task_6;

public class tasks {

    private int min;
    private int max;

    public tasks() {
        this.min = 0;
        this.max = 0;
    }

    public tasks(int value) {
        this.min = value;
        this.max = value;
    }

    public tasks(int a, int b) {

        this.min = Math.min(this.min, Math.min(a, b));
        this.max = Math.max(this.max, Math.max(a, b));

    }

    public void setValues(int value) {
        if (value < min) {
            min = value;
        } else if (value > max) {
            max = value;
        }
    }

    public void setValues(int first, int second) {
        this.min = Math.min(this.min, Math.min(first, second));
        this.max = Math.max(this.max, Math.max(first, second));
    }

    public void showValues() {
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Проверка (max >= min): " + (max >= min));
    }

}
