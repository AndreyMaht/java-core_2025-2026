package lr5.task_1;

public class task {

    private char symbol;


    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCharCode() {
        return (int) symbol; //
    }

    public void displayCharAndCode() {
        System.out.println("Символ: '" + symbol + "', Код: " + (int) symbol);
    }

}
