package lr7.task_5;

public class SuperClass {

    private String str1;

    public SuperClass(String str1) {
        this.str1 = str1;
    }

    public String getStr1() {
        return str1;
    }

    public void display() {
        System.out.println("Название класса: " + getClass().getSimpleName());
        System.out.println("Значение поля(str1) : " + str1);
    }

}
