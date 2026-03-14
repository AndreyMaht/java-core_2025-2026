package lr9.task_7;

public class Main {
    public static void main(String[] args) {

        int n = 100_000;

        long start = System.nanoTime();
        int result1 = alist.ArrayList(n);
        long end = System.nanoTime();
        System.out.println("ArrayList time: " + (end - start)/1e6 + " ms");

        start = System.nanoTime();
        int result2 = llist.LinkedListByIndex(n);
        end = System.nanoTime();
        System.out.println("LinkedList (by index) time: " + (end - start)/1e6 + " ms");

    }
}
