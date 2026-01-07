package lr7.task_5;

public class Main {
    public static void main(String[] args) {

        SuperClass supObj = new SuperClass("Hello");
        SubOneClass subObj1 = new SubOneClass("Hi", 5);
        SubTwoClass subObj2 = new SubTwoClass("Bye", 'A');

        supObj.display();
        subObj1.display();
        subObj2.display();

        System.out.println("Вызов метода через объектную переменную суперкласса:");

        SuperClass ref1 = subObj1;
        SuperClass ref2 = subObj2;

        ref1.display();
        ref2.display();

    }
}
