import java.util.concurrent.TimeUnit;
class ThirdThread extends Thread {
    public void run() {
        while (true) {
            for (int i = 100; i <= 130; i++) {
                System.out.println("Thread 3: " + i);
                try {
                    TimeUnit.SECONDS.sleep(1); // Opóźnienie 1 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}