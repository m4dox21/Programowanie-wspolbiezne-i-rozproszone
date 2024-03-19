import java.util.Random;

public class MyThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    int number = random.nextInt();
                    sum += number;
                }
                double average = (double) sum / 100;
                System.out.println("[Thread 1] " + average);
            }
        });

        Thread thread2 = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int product = 1;
                for (int i = 0; i < 30; i++) {
                    int number = random.nextInt();
                    product *= number;
                }
                double geometricMean = Math.pow(product, 1.0 / 30);
                System.out.println("[Thread 2] " + geometricMean);
            }
        });

        Thread thread3 = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int randomNumber = random.nextInt(40) - 20;
                double result = Math.log(Math.pow(randomNumber, 2));
                System.out.println("[Thread 3] " + result);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
