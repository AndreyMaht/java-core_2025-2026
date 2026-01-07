package lr7.task_4;

public class SubSubClass extends SubClass{

    public int num1;

    public SubSubClass(char ch1, String str1, int num1) {
        super(ch1, str1);
        this.num1 = num1;
    }

    public SubSubClass(SubSubClass obj) {
        super(obj);
        this.num1 = obj.num1;
    }

}
