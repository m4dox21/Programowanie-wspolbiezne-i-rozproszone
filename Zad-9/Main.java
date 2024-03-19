import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger number = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            int randomNumber = new Random().nextInt(10000);
            System.out.println("Wątek 1: Wylosowana liczba to " + randomNumber);
            number.set(randomNumber);
        });

        Thread t2 = new Thread(() -> {
            int modifiedNumber = number.get() + 2;
            System.out.println("Wątek 2: Liczba po zwiększeniu o 2 to " + modifiedNumber);
            number.set(modifiedNumber);
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Wątek 3: Wyświetlona liczba to " + number.get());
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}
