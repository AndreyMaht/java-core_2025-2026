package lr3;

public class task_8 {
    public static void main(String[] args) {

        char[] massive = new char[10];

        char letter = 'A';
        int index = 0;

        while (index < massive.length) {

            if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' || letter == 'Y') {
                letter++;
                continue;
            }

            massive[index] = letter;
            index++;
            letter++;
        }
        System.out.println(massive);
    }
}
