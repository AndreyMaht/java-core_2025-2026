package lr5.task_5;

public class task_5 {

    private int num;

    public task_5(int num) {
        if (num > 100) {
            this.num = 100;
        } else {
            this.num = num;
        }
    }

    public void setNum(int n) {
        if (n > 100) {
            this.num = 100;
        } else {
            this.num = n;
        }
    }

    public void setNum() {
        this.num = 0;
    }

    public void showNum() {
        System.out.println("Значение поля:" + num);
    }

}
