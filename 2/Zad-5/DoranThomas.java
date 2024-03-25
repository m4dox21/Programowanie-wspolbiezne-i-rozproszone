public class DoranThomas {
    private volatile boolean choice1 = false;
    private volatile boolean choice2 = false;
    private volatile int kto_czeka = 1;

    public void thread1() {
        while (true) {
            // Sekcja lokalna
            choice1 = true;
            if (choice2) {
                if (kto_czeka == 1) {
                    choice1 = false;
                    while (kto_czeka == 1) {
                        // nic nie rób
                    }
                    choice1 = true;
                }
                while (choice2) {
                    // nic nie rób
                }
            }
            // Sekcja krytyczna
            System.out.println("Wątek 1 start SK");
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                System.err.println("Wątek 1 przerwany: " + e.getMessage());
            }
            System.out.println("Wątek 1 stop SK");

            // Koniec sekcji krytycznej
            choice1 = false;
            kto_czeka = 1;
        }
    }

    public void thread2() {
        while (true) {
            // Sekcja lokalna
            choice2 = true;
            if (choice1) {
                if (kto_czeka == 2) {
                    choice2 = false;
                    while (kto_czeka == 2) {
                        // nic nie rób
                    }
                    choice2 = true;
                }
                while (choice1) {
                    // nic nie rób
                }
            }
            // Sekcja krytyczna
            System.out.println("Wątek 2 start SK");
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                System.err.println("Wątek 2 przerwany: " + e.getMessage());
            }
            System.out.println("Wątek 2 stop SK");

            // Koniec sekcji krytycznej
            choice2 = false;
            kto_czeka = 2;
        }
    }

    public static void main(String[] args) {
        DoranThomas doranThomas = new DoranThomas();

        Thread thread1 = new Thread(() -> {
            doranThomas.thread1();
        });

        Thread thread2 = new Thread(() -> {
            doranThomas.thread2();
        });

        thread1.start();
        thread2.start();
    }
}
