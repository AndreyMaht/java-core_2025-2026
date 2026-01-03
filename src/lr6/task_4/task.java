package lr6.task_4;

public class task {

    public static long doubleFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }

        long result = 1;

        for (int i = n; i > 0; i -= 2) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Факториал двойного числа = " + doubleFactorial(6));
    }

}
