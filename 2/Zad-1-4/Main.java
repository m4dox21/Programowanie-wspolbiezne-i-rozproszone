import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main implements Runnable {
    static AtomicIntegerArray k = new AtomicIntegerArray(2);
    private int mojNum;

    static {
        k.set(0, 1);
        k.set(1, 1);
    }

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

            // protokół wstępny
            k.set(mojNum, 0);
            while (k.get(1 - mojNum) == 0) {
                k.set(mojNum, 1);
                Thread.yield();
                k.set(mojNum, 0);
            }

            // sekcja krytyczna
            System.out.println("Wątek " + mojNum + " start SK");
            try {
                Thread.sleep((long) (2100 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Wątek " + mojNum + " stop SK");

            // protokół końcowy
            k.set(mojNum, 1);
        }
    }

    public Main() {
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
        new Thread(new Main()).start();
    }
}
