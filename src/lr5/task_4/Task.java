package lr5.task_4;

public class Task {

    private char symbol;
    private int num;

    public Task(char symbol, int num) {
        this.symbol = symbol;
        this.num = num;
        System.out.println("Создан объект: символ='" + symbol + "', число=" + num);
    }

    public Task(double value) {
        int intValue = (int) value;
        this.symbol = (char) intValue;

        double fractional = value - intValue;
        this.num = (int) (fractional * 100);

        System.out.println("Создан объект из double " + value +
                ": символ='" + symbol + "' (код " + intValue +
                "), число=" + num + " (из дробной части " + fractional + ")");

    }



}
