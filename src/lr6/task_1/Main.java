package lr6.task_1;

public class Main {
    public static void main(String[] args) {

        task taskes = new task();

        taskes.setCh1OrStr1('l');
        taskes.setCh1OrStr1("Hello");

        System.out.println(taskes.ch1);
        System.out.println(taskes.str1);

        char[] chars1 = new char[5];
        chars1[0] = 'H';
        chars1[1] = 'e';
        chars1[2] = 'l';
        chars1[3] = 'p';
        chars1[4] = '!';
        taskes.setCh1OrStr1(chars1);

        System.out.println(taskes.ch1);
        System.out.println(taskes.str1);

        char[] chars2 = new char[1];
        chars2[0] = 'H';
        taskes.setCh1OrStr1(chars2);

        System.out.println(taskes.ch1);

    }
}
