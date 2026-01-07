package lr7.task_3;

public class SubSubClass extends SubClass1{

    public String str1;

    public void setValue(int num, char ch1, String str1) {
        super.setValue(num);
        super.setValue(ch1);
        this.str1 = str1;
    }

    public SubSubClass(int num, char ch1, String str1) {
        super(num, ch1);
        this.str1 = str1;
    }

    @Override
    public String toString() {
        String ClassNameAndFieldValue;

        ClassNameAndFieldValue = " SubClass name: " + this.getClass().getSimpleName() + "\n" +
                " num = " + this.num + "\n" +
                " ch1 = " + this.ch1 + "\n" +
                " str1 = " + this.str1;

        return ClassNameAndFieldValue;

    }

}
