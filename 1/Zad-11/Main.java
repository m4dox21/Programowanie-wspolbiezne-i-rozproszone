import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> oddNumbersQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Integer> evenNumbersQueue = new LinkedBlockingQueue<>();

        Thread oddNumbersProducer = new Thread(() -> {
            try {
                int number = 1;
                while (true) {
                    oddNumbersQueue.put(number);
                    System.out.println("Przekazałem liczbę " + number);
                    number += 2;
                    Thread.sleep(1000); // Czekaj 1 sekundę
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread evenNumbersProducer = new Thread(() -> {
            try {
                int number = 2;
                while (true) {
                    evenNumbersQueue.put(number);
                    System.out.println("Przekazałem liczbę " + number);
                    number += 2;
                    Thread.sleep(1000); // Czekaj 1 sekundę
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread receiver = new Thread(() -> {
            try {
                while (true) {
                    int oddNumber = oddNumbersQueue.take();
                    int evenNumber = evenNumbersQueue.take();
                    int biggerNumber = Math.max(oddNumber, evenNumber);
                    System.out.println("Większą liczbą jest " + biggerNumber);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        oddNumbersProducer.start();
        evenNumbersProducer.start();
        receiver.start();
    }
}
