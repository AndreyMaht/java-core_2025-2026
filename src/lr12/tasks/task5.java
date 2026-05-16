package lr12.tasks;

public class task5 {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {3, 52, 12, 85, 1, -5, 105, 43, 23, 7, 64, 15};
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер (потоков): " + numThreads);

        Thread[] threads = new Thread[numThreads];
        int[] localMaximums = new int[numThreads];

        int chunkSize = (int) Math.ceil((double) array.length / numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;

            int start = threadIndex * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                int max = Integer.MIN_VALUE;

                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                localMaximums[threadIndex] = max;
            });

            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            if (localMaximums[i] > globalMax) {
                globalMax = localMaximums[i];
            }
        }

        System.out.println("Максимальный элемент в массиве: " + globalMax);
    }

}
