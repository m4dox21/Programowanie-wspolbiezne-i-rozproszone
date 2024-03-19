public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");

        for (int i = 1; i <= 5; i++) {
            new Thread(threadGroup, new MyRunnable(i), "Thread " + i).start();
        }

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadGroup.interrupt();
    }

    private static class MyRunnable implements Runnable {
        private final int threadNumber;

        public MyRunnable(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadNumber + " started.");
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread " + threadNumber + ": " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            } finally {
                System.out.println("Thread " + threadNumber + " finished.");
            }
        }
    }
}
