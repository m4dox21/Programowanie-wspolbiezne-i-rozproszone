import java.util.concurrent.atomic.AtomicIntegerArray;

class MyThread extends Thread {
    public static final int N = 2;
    private int numer;
    static AtomicIntegerArray chce = new AtomicIntegerArray(N);
    static AtomicIntegerArray kto_czeka = new AtomicIntegerArray(N);

    static class ThreadID {
        private static volatile int nextID = 0;
        private static ThreadLocal<Integer> threadID = ThreadLocal.withInitial(() -> nextID++);

        public static int get() {
            return threadID.get();
        }
    }

    static {
        for (int i = 0; i < N; i++) {
            chce.set(i, 0);
            kto_czeka.set(i, 0);
        }
    }

    MyThread(String nazwa) {
        super(nazwa);
    }

    @Override
    public void run() {
        numer = ThreadID.get();

        while (true) {
            // sekcja lokalna
            try {
                Thread.sleep((long) (2500 * Math.random()));
            } catch (InterruptedException e) {
            }

            // protokół wstępny
            int innyWatek = 1 - numer;
            chce.set(numer, 1);
            kto_czeka.set(1 - numer, numer);

            while (chce.get(innyWatek) == 1 && kto_czeka.get(numer) == numer) {
                // czekaj
            }

            // sekcja krytyczna
            System.out.println("Wątek " + numer + " start SK");
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Wątek " + numer + " stop SK");

            // protokół końcowy
            chce.set(numer, 0);
        }
    }
}
