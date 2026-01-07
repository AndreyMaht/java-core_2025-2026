package lr7.task_5;

public class SubTwoClass extends SuperClass{

    protected char ch1;

    public SubTwoClass(String str1, char ch1) {
        super(str1);
        this.ch1 = ch1;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Название класса: " + getClass().getSimpleName());
        System.out.println("Значение поля(ch1) : " + ch1);
    }

}
