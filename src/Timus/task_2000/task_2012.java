package Timus.task_2000;

import java.io.PrintWriter;
import java.util.Scanner;

public class task_2012 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int numbersOfTasks = in.nextInt();

        int difference = 12 - numbersOfTasks;

        int time = difference * 45;

        String result = time <= 240 ? "YES" : "NO";

//        if (time <= 240) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }

        out.println(result);
        out.flush();

    }

}
