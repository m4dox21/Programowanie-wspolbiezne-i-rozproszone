public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");

        for (int i = 1; i <= 3; i++) {
            new Thread(threadGroup, new MyRunnable(), "Thread " + i).start();
        }

        System.out.println("Liczba aktywnych wątków w grupie: " + threadGroup.activeCount());
        System.out.println("Lista wątków w grupie:");
        threadGroup.list();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " started.");
            try {
                Thread.sleep(1000); // Odczekanie 1 sekundy
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(threadName + " finished.");
        }
    }
}
