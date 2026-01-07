package lr7.task_3;

public class Main {

    public static void main(String[] args) {

        SuperClass1 supClass = new SuperClass1(5);

        System.out.println("Number = " + supClass.num);
        System.out.println(" toString = " + supClass.toString());

        SubClass1 subClass = new SubClass1(10, 'F');

        System.out.println("Number = " + subClass.num);
        System.out.println("Char = " + subClass.ch1);
        System.out.println(" toString = " + subClass.toString());

        SubSubClass subSubClass = new SubSubClass(15, 'A', "Hello");

        System.out.println("Number = " + subSubClass.num);
        System.out.println("Char = " + subSubClass.ch1);
        System.out.println("String = " + subSubClass.str1);
        System.out.println(" toString = " + subSubClass.toString());


    }

}
