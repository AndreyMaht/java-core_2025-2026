package lr7.task_2;

public class SubSuperClass extends SuperClass {

    public SubSuperClass(String str1) {
        super(str1);
    }

    public int num1;

    public SubSuperClass(String str1, int num1) {
        super(str1);
        this.num1 = num1;
    }

    public void setValue() {
        super.setValue("");
        this.num1 = 0;
    }

    @Override
    public void setValue(String text) {
        super.setValue(text);
    }

    public void setValue(int number) {
        this.num1 = number;
    }

    public void setValue(int number, String text) {
        this.num1 = number;
        super.setValue(text);
    }


}
