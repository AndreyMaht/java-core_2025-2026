package lr7.task_4;

public class Main {
    public static void main(String[] args) {

        SupClass sClass = new SupClass('A');

        SubClass subClass = new SubClass('B', "Hello");

        SubSubClass subSubClass = new SubSubClass('C', "Hi", 10);

        System.out.println("Original Objects");
        System.out.println(sClass.ch1);
        System.out.println(subClass.ch1 + " " + subClass.str1);
        System.out.println(subSubClass.ch1 + " " + subSubClass.str1 + " " + subSubClass.num1);


        SupClass copyClass = new SupClass(sClass);
        SubClass copySub = new SubClass(subClass);
        SubSubClass copySubSub = new SubSubClass(subSubClass);

        System.out.println("Copy Objects");
        System.out.println(copyClass.ch1);
        System.out.println(copySub.ch1 + copySub.str1);
        System.out.println(copySubSub.ch1 + copySubSub.str1 + copySubSub.num1);


    }
}
