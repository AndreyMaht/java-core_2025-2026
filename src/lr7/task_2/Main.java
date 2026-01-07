package lr7.task_2;

public class Main {
    public static void main(String[] args) {

        SuperClass superObj = new SuperClass("Привет");

        System.out.println(superObj.getStr1());

        SubSuperClass subClass = new SubSuperClass("Hello", 10);

        System.out.println(subClass.num1);
        System.out.println(subClass.getStr1());

        subClass.setValue(50);

        System.out.println(subClass.num1);

    }
}
