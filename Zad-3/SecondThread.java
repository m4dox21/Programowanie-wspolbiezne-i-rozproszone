import java.util.concurrent.TimeUnit;
class SecondThread extends Thread {
    public void run() {
        while (true) {
            for (int i = 50; i <= 88; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    TimeUnit.SECONDS.sleep(1); // Opóźnienie 1 sekundy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}