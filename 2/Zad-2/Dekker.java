public class Dekker implements Runnable {
    private static volatile boolean[] k = {false, false};
    private static volatile int czyjaKolej = 0;
    private int mojNum;

    public void run() {
        mojNum = Integer.parseInt(Thread.currentThread().getName());

        while (true) {
            try {
                Thread.sleep((long) (2500 * Math.random()));
            } catch (InterruptedException e) {
            }

            k[mojNum] = true;

            while (k[1 - mojNum]) {
                if (czyjaKolej != mojNum) {
                    k[mojNum] = false;
                    while (czyjaKolej != mojNum) {
                        Thread.yield();
                    }
                    k[mojNum] = true;
                }
            }

            System.out.println("Wątek " + mojNum + " start SK");
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Wątek " + mojNum + " stop SK");

            czyjaKolej = 1 - mojNum;
            k[mojNum] = false;
        }
    }

    public static void main(String[] args) {
        new Thread(new Dekker(), "0").start();
        new Thread(new Dekker(), "1").start();
    }
}
