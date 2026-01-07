package lr7.task_1;

public class Main {
    public static void main(String[] args) {

        SuperClassTest superClassObj = new SuperClassTest("передал в конструктор суперкласса");
        String className = superClassObj.toString();
        System.out.println(className);

        SubClassTest subClassObj1 = new SubClassTest("передал в конструктор подкласса");
        String SubClassName = subClassObj1.toString();
        System.out.println(SubClassName);

        SubClassTest subClassObj2 = new SubClassTest("передал в конструктор суперкласса", "где 2 параметра");
        String SubClassName2 = subClassObj2.toString();
        System.out.println(SubClassName2);

    }
}
