package lr7.task_5;

public class SubOneClass extends SuperClass {

    protected int num1;

    public SubOneClass(String str1, int num1) {
        super(str1);
        this.num1 = num1;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Название класса: " + getClass().getSimpleName());
        System.out.println("Значение поля(num1) : " + num1);
    }


}
