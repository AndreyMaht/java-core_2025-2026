package lr7.task_3;

public class SuperClass1 {

    public int num;

    public void setValue(int num) {
        this.num = num;
    }

    public SuperClass1(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String ClassNameAndFieldValue;

        ClassNameAndFieldValue = " Class name: " + this.getClass().getSimpleName() + "\n" +
                " num = " + this.num;

        return ClassNameAndFieldValue;

    }

}
