package lr6.task_5;

public class task {

    public static long sumLoop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n должно быть натуральным числом");
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (long) i * i;
        }
        return sum;
    }

    public static long sumFormula(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n должно быть натуральным числом");
        }
        return (long) n * (n + 1) / 2 * (2 * n + 1) / 3;
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println("n = " + n);

        long resultLoop = sumLoop(n);

        long resultFormula = sumFormula(n);

        System.out.println("Сумма квадратов (цикл): " + resultLoop);
        System.out.println("Сумма квадратов (формула): " + resultFormula);

    }

}
