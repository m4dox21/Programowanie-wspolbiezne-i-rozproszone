import java.util.concurrent.TimeUnit;

class FirstThread extends Thread {
    public void run() {
        while (true) {
            for (int i = 1; i <= 33; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    TimeUnit.SECONDS.sleep(1); // Opóźnienie 1 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
