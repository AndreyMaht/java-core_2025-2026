package lr7.task_4;

public class SubClass extends SupClass{

    public String str1;

    public SubClass(char ch1, String str1) {
        super(ch1);
        this.str1 = str1;
    }

    public SubClass(SubClass obj) {
        super(obj);
        this.str1 = obj.str1;
    }

}
