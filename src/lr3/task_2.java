package lr3;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите название дня недели: ");
        String input = in.nextLine();

        String day = input.toLowerCase();

        switch (day) {
            case "понедельник":
                System.out.println("Порядковый номер: 1");
                break;
            case "вторник":
                System.out.println("Порядковый номер: 2");
                break;
            case "среда":
                System.out.println("Порядковый номер: 3");
                break;
            case "четверг":
                System.out.println("Порядковый номер: 4");
                break;
            case "пятница":
                System.out.println("Порядковый номер: 5");
                break;
            case "суббота":
                System.out.println("Порядковый номер: 6");
                break;
            case "воскресенье":
                System.out.println("Порядковый номер: 7");
                break;
            default:
                System.out.println("Некорректный день недели. Проверьте написание.");
                break;
        }


    }
}
