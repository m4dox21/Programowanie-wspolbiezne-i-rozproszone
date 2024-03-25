import java.util.concurrent.atomic.AtomicIntegerArray;

public class Piekarnia implements Lock {
    private static AtomicIntegerArray flaga;
    private static AtomicIntegerArray etykieta;

    public Piekarnia(int N) {
        etykieta = new AtomicIntegerArray(N);
        for (int i = 0; i < N; i++) {
            etykieta.set(i, 0);
        }
        flaga = new AtomicIntegerArray(N);
        for (int i = 0; i < N; i++) {
            flaga.set(i, 0);
        }
    }

    public void lock() {
        int mojNum = MyThread.ThreadID.get();
        flaga.set(mojNum, 1);
        int maks = Etykieta.maks(etykieta);
        etykieta.set(mojNum, maks + 1);
        while (nieMojaKolej(mojNum)) {
        }
    }

    public void unLock() {
        flaga.set(MyThread.ThreadID.get(), 0);
    }

    private boolean nieMojaKolej(int mojNum) {
        for (int k = 0; k < etykieta.length(); k++) {
            if (k != mojNum && (flaga.get(k) == 1) && Etykieta.jestPrzed(k, mojNum) == 1) {
                return true;
            }
        }
        return false;
    }

    static class Etykieta {
        static int maks(AtomicIntegerArray label) {
            int c = 0;
            for (int i = 0; i < label.length(); i++) {
                c = Math.max(c, label.get(i));
            }
            return c;
        }

        static int jestPrzed(int t1, int t2) {
            if (etykieta.get(t1) < etykieta.get(t2) || (etykieta.get(t1) == etykieta.get(t2) && t1 < t2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}