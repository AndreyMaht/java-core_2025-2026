package Timus.task_1000;

import java.util.Scanner;

public class task_1585 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        int emperorCount = 0;
        int macaroniCount = 0;
        int littleCount = 0;

        for (int i = 0; i < n; i++) {
            String penguin = in.nextLine();

            if (penguin.equals("Emperor Penguin")) {
                emperorCount++;
            } else if (penguin.equals("Macaroni Penguin")) {
                macaroniCount++;
            } else if (penguin.equals("Little Penguin")) {
                littleCount++;
            }
        }

        if (emperorCount > macaroniCount && emperorCount > littleCount) {
            System.out.println("Emperor Penguin");
        } else if (macaroniCount > emperorCount && macaroniCount > littleCount) {
            System.out.println("Macaroni Penguin");
        } else {
            System.out.println("Little Penguin");
        }

        in.close();
    }
}
