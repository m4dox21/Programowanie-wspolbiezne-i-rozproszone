import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main implements Runnable {
    static AtomicIntegerArray k = new AtomicIntegerArray(2);
    static volatile int czyjaKolej = 0;  // dodanie zmiennej czyjaKolej

    static {
        k.set(0, 1);
        k.set(1, 1);
    }

    private int mojNum;

    static class ThreadID {
        private static volatile int nextID = 0;
        private static ThreadLocal<Integer> threadID = ThreadLocal.withInitial(() -> nextID++);

        public static int get() {
            return threadID.get();
        }
    }

    public void run() {
        mojNum = ThreadID.get();

        while (true) {
            // sekcja lokalna
            try {
                Thread.sleep((long) (2500 * Math.random()));
            } catch (InterruptedException e) {
            }

            k.set(mojNum, 0);

            // sekcja krytyczna
            System.out.println("Wątek " + mojNum + " start SK");
            try {
                Thread.sleep((long) (2100 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Wątek " + mojNum + " stop SK");

            // protokół końcowy
            czyjaKolej = 1 - mojNum;
        }
    }

    public Main() {
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
        new Thread(new Main()).start();
    }
}
