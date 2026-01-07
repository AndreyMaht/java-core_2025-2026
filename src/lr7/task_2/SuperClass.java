package lr7.task_2;

public class SuperClass {

    private String str1;

    public void setValue(String str1) {
        this.str1 = str1;
    }

    public SuperClass(String str1) {
        this.str1 = str1;
    }

    public int getTextLength() {
        return str1.length();
    }

    public String getStr1() {
        return str1;
    }



}
