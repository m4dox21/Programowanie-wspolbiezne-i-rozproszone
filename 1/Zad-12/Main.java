import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wartość n:");
        int n = scanner.nextInt();
        System.out.println("Podaj liczbę zadań:");
        int taskCount = scanner.nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(taskCount);

        double sum = 0.0;
        int chunkSize = n / taskCount;
        int remainingTasks = n % taskCount;

        Future<Double>[] futures = new Future[taskCount];
        for (int i = 0; i < taskCount; i++) {
            int start = i * chunkSize + 1;
            int end = (i + 1) * chunkSize;
            if (i == taskCount - 1) {
                end += remainingTasks;
            }
            Callable<Double> task = new SumTask(start, end);
            futures[i] = executorService.submit(task);
        }

        for (Future<Double> future : futures) {
            try {
                sum += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        System.out.println("Suma dla n=" + n + ": " + sum);
    }
}


