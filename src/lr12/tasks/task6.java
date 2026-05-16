package lr12.tasks;

public class task6 {
    public static int sumArray(int[] array) throws InterruptedException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        int[] localSums = new int[numThreads];

        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;

            int start = threadIndex * chunkSize;
            int end = (threadIndex == numThreads - 1) ? array.length : (start + chunkSize);

            threads[threadIndex] = new Thread(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                localSums[threadIndex] = sum;
            });

            threads[threadIndex].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        int totalSum = 0;
        for (int i = 0; i < numThreads; i++) {
            totalSum += localSums[i];
        }

        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int result = sumArray(array);
        System.out.println("Сумма элементов массива: " + result);
    }
}
