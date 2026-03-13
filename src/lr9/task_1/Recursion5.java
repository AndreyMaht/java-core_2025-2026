package lr9.task_1;

//Пример 5. Вывести число Фибоначчи, заданное его номером в последовательности.

public class Recursion5 {

//    public static void main(String[] args) {
//        System.out.println(fact(5));
//    }
//
//    public static int fact(int n) {
//        if (n == 0) {
//            return  0;
//        } else if (n == 1) {
//            return 1;
//        } else {
//            return fact(n - 2) + fact(n - 1);
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Результат: " + fact(5));
    }

    public static int fact(int n) {
        System.out.println("Вход в fact(" + n + ")");

        if (n == 0) {
            System.out.println("Выход из fact(0) = 0");
            return 0;
        } else if (n == 1) {
            System.out.println("Выход из fact(1) = 1");
            return 1;
        } else {
            int result = fact(n - 2) + fact(n - 1);
            System.out.println("Выход из fact(" + n + ") = " + result);
            return result;
        }
    }

}
