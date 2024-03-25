import java.lang.ThreadLocal;

public class Main implements Runnable {
    volatile static int czyjaKolej = 0;
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

            // protokół wstępny
            while (czyjaKolej != mojNum) {
                Thread.yield();
            }

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
        new Thread(new Main(), "0").start();
        new Thread(new Main(), "1").start();
    }
}
