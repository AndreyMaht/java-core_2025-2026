package lr7.task_4;

public class SupClass {

    public char ch1;

    public SupClass(char ch1) {
        this.ch1 = ch1;
    }

    public SupClass(SupClass obj) {
        this.ch1 = obj.ch1;
    }

}
