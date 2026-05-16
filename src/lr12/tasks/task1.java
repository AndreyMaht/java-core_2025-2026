package lr12.tasks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class task1 {
    public static void main(String[] args) throws InterruptedException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now().format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now().format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
