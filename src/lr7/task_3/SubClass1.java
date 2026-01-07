package lr7.task_3;

public class SubClass1 extends SuperClass1{

    public char ch1;

    public void setValue(int num, char ch1) {
        super.setValue(num);
        this.ch1 = ch1;
    }

    public SubClass1(int num, char ch1) {
        super(num);
        this.ch1 = ch1;
    }

    @Override
    public String toString() {
        String ClassNameAndFieldValue;

        ClassNameAndFieldValue = " SubClass name: " + this.getClass().getSimpleName() + "\n" +
                " num = " + this.num + "\n" +
                " ch1 = " + this.ch1;

        return ClassNameAndFieldValue;

    }

}
