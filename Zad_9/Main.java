import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        var number = new AtomicInteger();
        var t1 = new Thread(() -> {
            number.set(new Random().nextInt(10000));
        });
       var t2 = new Thread(() -> {
           number.set(number.get() + 2);
       });

       var t3 = new Thread(() -> {
            System.out.println(number.get());
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }
}